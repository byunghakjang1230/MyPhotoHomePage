package com.jbh.service.admin;

import com.jbh.domain.admin.AdminVO;
import com.jbh.exception.NotExistIdException;
import com.jbh.exception.NotMatchException;

public interface MemberService {

	public AdminVO loginService(String id, String password)throws NotExistIdException, NotMatchException;
}
