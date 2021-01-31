package com.jbh.service.main;

import java.util.List;

import com.jbh.domain.main.PhotosVO;
import com.jbh.domain.main.VisiterDTO;

public interface MainService {

	public List<String> inquireMainBGI()throws Exception;
	
	public List<PhotosVO> inpuirePhotolist(String maincate, String subcate)throws Exception;
	
	public void insertVisiterInfo(VisiterDTO dto)throws Exception;
}
