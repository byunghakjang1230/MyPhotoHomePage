package com.jbh.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import com.jbh.domain.admin.VisiterPositionVO;
import com.jbh.service.admin.VisiterService;
import com.jbh.util.HttpClientUtil;
import com.jbh.util.RSAUtil;
import com.jbh.util.domain.insta.Data;
import com.jbh.util.domain.insta.InstaDTO;
import com.jbh.util.domain.insta.InstaVO;

@RestController
@RequestMapping("/api")
public class APIControllerRest {

	@Resource(name="instaAPI")
	private String instaAPI;
	
	@Inject
	private VisiterService vService;
	
	@ResponseBody
	@RequestMapping(value="/insta", method=RequestMethod.GET)
	public ResponseEntity<List<InstaVO>> instaAPIGet(){
		
		String imagestr = HttpClientUtil.get(instaAPI);
		
		if(!imagestr.equals("error")) {
			Gson gson = new Gson();
			List<InstaVO> volist = new ArrayList<>();
			InstaDTO dto = gson.fromJson(imagestr, InstaDTO.class);
			List<Data> list = dto.getData();
			for(Data data : list) {
				InstaVO vo = new InstaVO();
				vo.setLink(data.getLink());
				vo.setUrl(data.getImages().getStandard_resolution().getUrl());
				volist.add(vo);
			}
			return new ResponseEntity<>(volist, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/vp", method = RequestMethod.GET)
	public ResponseEntity<List<VisiterPositionVO>> visiterPositionGet(){
		try {
			return new ResponseEntity<>(vService.totalPosition(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/vs/{mode}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> visiterSTGet(@PathVariable("mode") String mode){
		try {
			return new ResponseEntity<>(vService.inquireVisiterST(mode), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/rsa", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> rsaKeyPairSend(HttpSession session){
		try {
			return new ResponseEntity<>(RSAUtil.setCrypto(session), HttpStatus.OK);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
