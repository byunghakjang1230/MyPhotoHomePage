package com.jbh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jbh.domain.admin.MessageVO;
import com.jbh.domain.admin.PageVO;
import com.jbh.service.admin.MessageService;
import com.jbh.service.admin.PhotoService;

@Controller
@RequestMapping("/ad")
public class AdminController {
	
	@Resource(name="lineOfPage")
	private int lineOfPage;
	
	@Resource(name="numOfLine")
	private int numOfLine;

	@Inject
	private PhotoService serivce;
	
	@Inject 
	private MessageService mgservice;
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String adminMainpageGet(Model model) {
		return "admin/main";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPageGet(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("admin") != null)
			session.removeAttribute("admin");
		
		return "redirect:/adlogin";
	}
	
	@RequestMapping(value="/rp", method = RequestMethod.GET)
	public String registPage(Model model) {
		try {
			List<String> maincate = serivce.inquireMaincate();
			model.addAttribute("maincate", maincate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/registphoto";
	}
	
	@RequestMapping(value="/mp", method = RequestMethod.GET)
	public String modifyPage(Model model) {
		try {
			List<String> maincate = serivce.inquireMaincate();
			model.addAttribute("maincate", maincate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/modifyphoto";
	}
	
	@RequestMapping(value="/vv", method=RequestMethod.GET)
	public String viewVisiter(Model model) {
		
		return "admin/viewvisiter";
	}
	
	
	
	@RequestMapping(value="/ml", method=RequestMethod.GET)
	public String messageList(Model model) {
		try {
			int total = mgservice.totalMessage();
			PageVO vo = new PageVO(1, numOfLine, lineOfPage, total);
			
			int start = vo.getCurrentPage() * lineOfPage - lineOfPage;
			List<MessageVO> msglist = mgservice.inquireMessageList(start, lineOfPage);
			
			model.addAttribute("msglist", msglist);
			model.addAttribute("page", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/message";
	}
	
	
	@RequestMapping(value="/ml/{page}", method=RequestMethod.GET)
	public String messageList(@PathVariable("page")String page, Model model) {
		int currentPage = 1;
		if(!page.isEmpty() || page != null)
			currentPage = Integer.parseInt(page);
		
		try {
			int total = mgservice.totalMessage();
			PageVO vo = new PageVO(currentPage, numOfLine, lineOfPage, total);
			
			int start = vo.getCurrentPage() * lineOfPage - lineOfPage;
			List<MessageVO> msglist = mgservice.inquireMessageList(start, lineOfPage);
			
			model.addAttribute("msglist", msglist);
			model.addAttribute("page", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/message";
	}
	
}
