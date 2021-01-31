package com.jbh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileGetControllerRest {
	
	@Resource(name="filePath")
	private String filePath;

	@Resource(name="tempPath")
	private String tempPath;
	
	@RequestMapping(value="/img/{maincate}/{subcate}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImgeFile(@PathVariable("maincate") String maincate, @PathVariable("subcate") String subcate,
			@RequestParam("filename") String filename){
		String fullname = filePath + File.separator + maincate + File.separator + subcate + File.separator + filename;
		HttpHeaders headers = new HttpHeaders();
		InputStream in = null;
		headers.setContentType(MediaType.IMAGE_JPEG);
		try {
			in = new FileInputStream(fullname);
			byte[] img = IOUtils.toByteArray(in);
			return new ResponseEntity<>(img, headers, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/temp", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getTempImgeFile(@RequestParam("filename") String filename){
		String fullname = tempPath + File.separator + filename;
		HttpHeaders headers = new HttpHeaders();
		InputStream in = null;
		headers.setContentType(MediaType.IMAGE_JPEG);
		try {
			in = new FileInputStream(fullname);
			return new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
