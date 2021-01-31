package com.jbh.dao;

import java.util.List;

import com.jbh.domain.admin.VisiterPositionVO;
import com.jbh.domain.admin.VisiterSTVO;
import com.jbh.domain.main.VisiterDTO;

public interface VisiterDAO {

	public List<VisiterPositionVO> totalPosition()throws Exception;
	
	public List<VisiterSTVO> inquireVisiterST(String date)throws Exception;
	
	public int inquireCount(String date)throws Exception;
	
	public void insertVisiterInfo(VisiterDTO dto)throws Exception;
}
