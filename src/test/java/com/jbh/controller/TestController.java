package com.jbh.controller;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.sql.DataSource;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import com.jbh.dao.PhotoDAO;
import com.jbh.dao.VisiterDAO;
import com.jbh.domain.admin.MessageDTO;
import com.jbh.domain.admin.MessageVO;
import com.jbh.domain.admin.PageVO;
import com.jbh.domain.admin.VisiterPositionVO;
import com.jbh.domain.admin.VisiterSTVO;
import com.jbh.domain.main.BGImgVO;
import com.jbh.domain.main.PhotosVO;
import com.jbh.domain.main.VisiterDTO;
import com.jbh.domain.main.VisiterVO;
import com.jbh.service.admin.MessageService;
import com.jbh.service.main.MainService;
import com.jbh.util.CookieUtil;
import com.jbh.util.HttpClientUtil;
import com.jbh.util.ImgUtil;
import com.jbh.util.domain.insta.InstaDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class TestController {

	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	private static final String namespace = "org.hilu0318.mapper.Photo";
	
	@Resource(name="instaAPI")
	private String instaAPI;
	
	@Resource(name="tempPath")
	private String tempPath;
	
	@Resource(name="ipAPIfront")
	private String ipAPIfront;
	
	@Resource(name="ipAPIback")
	private String ipAPIback;
	
	@Inject
	private SqlSession session;
	
	@Inject
	private DataSource ds;
	
	@Inject
	private VisiterDAO dao;
	
	@Inject
	private MainService mservice;
	
	@Resource(name="lineOfPage")
	private int lineOfPage;
	
	@Resource(name="numOfLine")
	private int numOfLine;
	
	@Inject
	private MessageService mgservice;
	
	@Test
	public void test() {
		try(Connection con = ds.getConnection()){
			System.out.println("Connection Complete!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FALSE");
		}
	}
	
	
}
