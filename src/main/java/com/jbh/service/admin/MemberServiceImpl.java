package com.jbh.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jbh.dao.MemberDAO;
import com.jbh.domain.admin.AdminVO;
import com.jbh.domain.admin.MemberVO;
import com.jbh.exception.NotExistIdException;
import com.jbh.exception.NotMatchException;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public AdminVO loginService(String id, String password) throws NotExistIdException, NotMatchException {
		try {
			AdminVO avo = new AdminVO();
			MemberVO vo = dao.inquireMember(id);
			
			if(vo == null)
				throw new NotExistIdException();
			if(!matchPassword(vo.getPassword(), password))
				throw new NotMatchException();
			
			avo.setName(vo.getName());
			avo.setNickName(vo.getNickname());
			avo.setAuthority(vo.getAuthority());
			return avo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	private boolean matchPassword(String password, String confirmpw) {
		return password.equals(confirmpw);
	}


}
