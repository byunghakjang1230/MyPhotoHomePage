package com.jbh.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbh.domain.admin.EmailDTO;
import com.jbh.domain.admin.MessageDTO;
import com.jbh.service.admin.MessageService;
import com.jbh.util.CookieUtil;
import com.jbh.util.RSAUtil;

@RestController
@RequestMapping("/ms")
public class MessageControllerRest {
	
	@Resource(name="msgSendCookie")
	private String msgSendCookie;
	
	@Resource(name="msgSendCookieMaxAge")
	private int msgSendCookieMaxAge;
	
	@Resource(name="mailDefaultTitle")
	private String mailDefaultTitle;
	
	@Inject
	private MessageService service;
	
	@Inject
	private JavaMailSender sender;

	
	@RequestMapping(value="/r", method = RequestMethod.POST)
	public ResponseEntity<String> messageRegistPost(@RequestBody MessageDTO dto, HttpServletRequest req, HttpServletResponse res){
		CookieUtil cook = new CookieUtil(req);
		HttpSession session = req.getSession();
		try {			
			if(!cook.exists(msgSendCookie)) {
				UUID uuid = UUID.randomUUID();
				Cookie cookie = CookieUtil.createCookie(msgSendCookie, uuid.toString(), msgSendCookieMaxAge);
				res.addCookie(cookie);

				MessageDTO ndto = new MessageDTO();
				RSAUtil.getPrivateKey(session);
				ndto.setName(RSAUtil.decryptRSA(dto.getName()));
				ndto.setEmail(RSAUtil.decryptRSA(dto.getEmail()));
				ndto.setMessage(RSAUtil.decryptRSA(dto.getMessage()));

				service.insertMessage(ndto);
				
				return new ResponseEntity<>("success", HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/s", method = RequestMethod.POST)
	public ResponseEntity<List<String>> mailSend(@RequestBody EmailDTO dto, HttpSession session){
		SimpleMailMessage email = new SimpleMailMessage();
		try {
			RSAUtil.getPrivateKey(session);
			String emailaddress = RSAUtil.decryptRSA(dto.getEmailaddress());
			String message = RSAUtil.decryptRSA(dto.getMessage());
			List<String> list = new ArrayList<>();
			list.add(emailaddress);
			list.add(message);
			
			email.setTo(emailaddress);
			email.setText(message);
			email.setSubject(mailDefaultTitle);
			
			sender.send(email);
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
