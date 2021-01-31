package com.jbh.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import com.jbh.domain.admin.AdminVO;
import com.jbh.domain.main.PhotosVO;
import com.jbh.domain.main.VisiterDTO;
import com.jbh.exception.NotExistIdException;
import com.jbh.exception.NotMatchException;
import com.jbh.service.admin.MemberService;
import com.jbh.service.main.MainService;
import com.jbh.util.CookieUtil;
import com.jbh.util.HttpClientUtil;
import com.jbh.util.RSAUtil;

@Controller
public class MainController {

	@Inject
	private MainService mservice;
	
	@Inject
	private MemberService mbservice;
	
	@Resource(name="ipAPIfront")
	private String ipAPIfront;
	
	@Resource(name="ipAPIback")
	private String ipAPIback;
	
	@Resource(name="visiterCookie")
	private String visiterCookie;
	
	@Resource(name="visiterCookieMaxAge")
	private int visiterCookieMaxAge;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String mainVisit(HttpServletRequest req, HttpServletResponse res, Model model) {
		HttpSession session = req.getSession();
		CookieUtil cook = new CookieUtil(req);
				
		try {
			if(!cook.exists(visiterCookie) && session.getAttribute("admin") == null) {
				UUID uuid = UUID.randomUUID();
				
				VisiterDTO dto = registIPPosition(req);
				
				Cookie cookie = CookieUtil.createCookie(visiterCookie, uuid.toString(), visiterCookieMaxAge);
				res.addCookie(cookie);
				mservice.insertVisiterInfo(dto);
			}
			
			List<String> vo = mservice.inquireMainBGI();
			model.addAttribute("bgimglist", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "main/mainpage";
	}


	@RequestMapping(value="/pf", method=RequestMethod.GET)
	public String portfolioVisit(Model model) {
		try {
			List<PhotosVO> volist = mservice.inpuirePhotolist("portfolio", "etc");
			model.addAttribute("photolist", volist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main/portfolio";
	}
	
	@RequestMapping(value="/gm/{cate}", method=RequestMethod.GET)
	public String firstgalleryVisit(@PathVariable("cate")String cate, Model model) {
		
		return "main/gm/"+cate;
	}
	
	@RequestMapping(value="/gal/{maincate}/{subcate}", method=RequestMethod.GET)
	public String galleryVisit(@PathVariable("maincate")String maincate, @PathVariable("subcate") String subcate, Model model) {
		try {
			List<PhotosVO> volist = mservice.inpuirePhotolist(maincate, subcate);
			model.addAttribute("photolist", volist);
			model.addAttribute("maincate", maincate);
			model.addAttribute("subcate", subcate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main/gallery";
	}
	
	@RequestMapping(value="/ct", method=RequestMethod.GET)
	public String contactPage(Model model) {
		
		return "main/contact";
	}
	
	@RequestMapping(value="/adlogin", method = RequestMethod.GET)
	public String adminLoginPageGet(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("admin") != null)
			return "admin/main";

		try {
			RSAUtil.setCrypto(model, session);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			model.addAttribute("error", true);
		}
		return "admin/login";
	}
	
	@RequestMapping(value="/adlogin", method = RequestMethod.POST)
	public String adminLoginPagePost(@RequestParam("id") String sid, @RequestParam("password") String spassword, HttpServletResponse res, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		Map<String, Boolean> errors = new HashMap<>();
		String resultPath = "redirect:/ad/main";
		try {
			RSAUtil.getPrivateKey(session);
			String id = RSAUtil.decryptRSA(sid);
			String password = RSAUtil.decryptRSA(spassword);
			AdminVO vo = mbservice.loginService(id, password);
			
			//VisiterDTO dto = registIPPosition(req);
			session.setAttribute("admin", vo);
			
		} catch (NotExistIdException e) {
			errors.put("id", Boolean.TRUE);
			resultPath = "admin/login";
		} catch(NotMatchException e) {
			errors.put("password", Boolean.TRUE);
			resultPath = "admin/login";
		} catch(Exception e) {
			e.printStackTrace();
			errors.put("key", Boolean.TRUE);
			resultPath = "admin/login";
		}
		
		model.addAttribute("errors", errors);
		return resultPath;
	}
	
	@RequestMapping(value="/webpfpage", method=RequestMethod.GET)
	public String webPortfolioGet(HttpServletRequest req, HttpServletResponse res, Model model) {
		CookieUtil cook = new CookieUtil(req);
		try {
			if(!cook.exists(visiterCookie)) {
				UUID uuid = UUID.randomUUID();
				
				String ip = HttpClientUtil.getIp(req);
				String result = HttpClientUtil.get(ipAPIfront+ip+ipAPIback);
				VisiterDTO dto = new VisiterDTO();
				
				if(!result.equals("error")) {
					Gson gson = new Gson();
					dto = gson.fromJson(result, VisiterDTO.class);
					if(dto.getStatus().equals("fail"))
						dto.setStatusFail();
				}else {
					dto.setError();
				}
				Cookie cookie = CookieUtil.createCookie(visiterCookie, uuid.toString(), visiterCookieMaxAge);
				res.addCookie(cookie);
				mservice.insertVisiterInfo(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "admin/webpf";
	}
	
	private VisiterDTO registIPPosition(HttpServletRequest req) {
		String ip = HttpClientUtil.getIp(req);
		String result = HttpClientUtil.get(ipAPIfront+ip+ipAPIback);
		VisiterDTO dto = new VisiterDTO();
		
		if(!result.equals("error")) {
			Gson gson = new Gson();
			dto = gson.fromJson(result, VisiterDTO.class);
			if(dto.getStatus().equals("fail"))
				dto.setStatusFail();
		}else {
			dto.setError();
		}
		return dto;
	}
}
