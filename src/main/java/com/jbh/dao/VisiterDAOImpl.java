package com.jbh.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jbh.domain.admin.VisiterPositionVO;
import com.jbh.domain.admin.VisiterSTVO;
import com.jbh.domain.main.VisiterDTO;

@Repository
public class VisiterDAOImpl implements VisiterDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.hilu0318.mapper.Admin";
	
	@Override
	public List<VisiterPositionVO> totalPosition() throws Exception {
		return session.selectList(namespace+".totalPosition");
	}

	@Override
	public List<VisiterSTVO> inquireVisiterST(String date) throws Exception {
		return session.selectList(namespace+".inquireVisiterST", date);
	}

	@Override
	public int inquireCount(String date) throws Exception {
		return session.selectOne(namespace+".inquireCount", date);
	}

	@Override
	public void insertVisiterInfo(VisiterDTO dto) throws Exception {
		session.insert(namespace+".insertVisiterInfo", dto);
	}

}
