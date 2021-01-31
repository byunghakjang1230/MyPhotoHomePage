package com.jbh.dao;

import com.jbh.domain.admin.MemberVO;

public interface MemberDAO {

	public MemberVO inquireMember(String id)throws Exception;
}
