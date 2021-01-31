package com.jbh.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestControllerRest {
	
	@Inject
	private DataSource ds;
	
	@Resource(name="filePath")
	private String filePath;

	@Resource(name="tempPath")
	private String tempPath;
	
	@ResponseBody
	@RequestMapping(value="/db", method = RequestMethod.GET)
	public ResponseEntity<String> getCheckDBConnection(){
		try(Connection conn = ds.getConnection()){
			return new ResponseEntity<String>("True", HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("False", HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/path", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getCheckFilePath(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("filePath", this.filePath);
		map.put("tempPath", this.tempPath);
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
}
