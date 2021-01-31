package com.jbh.service.main;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbh.dao.PhotoDAO;
import com.jbh.dao.VisiterDAO;
import com.jbh.domain.main.PhotosVO;
import com.jbh.domain.main.VisiterDTO;

@Service
public class MainServiceImpl implements MainService {

	@Inject
	private PhotoDAO dao;
	
	@Inject
	private VisiterDAO vdao;
	
	@Override
	public List<String> inquireMainBGI() throws Exception {
		return dao.inquireMainBGI();
	}

	@Override
	public List<PhotosVO> inpuirePhotolist(String maincate, String subcate) throws Exception {
		return dao.inpuirePhotolist(maincate, subcate);
	}

	@Transactional
	@Override
	public void insertVisiterInfo(VisiterDTO dto) throws Exception {
		vdao.insertVisiterInfo(dto);
	}
}
