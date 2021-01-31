package com.jbh.service.admin;

import java.util.List;
import java.util.Map;

import com.jbh.domain.admin.VisiterPositionVO;

public interface VisiterService {

	public List<VisiterPositionVO> totalPosition()throws Exception;
	
	public Map<String, Object> inquireVisiterST(String date)throws Exception;
}
