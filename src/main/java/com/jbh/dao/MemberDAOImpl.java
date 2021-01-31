package com.jbh.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jbh.domain.admin.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.hilu0318.mapper.Admin";
	
	@Override
	public MemberVO inquireMember(String id) throws Exception {
		return session.selectOne(namespace+".inquireMember", id);
	}

}
