package com.jbh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jbh.domain.admin.MessageDTO;
import com.jbh.domain.admin.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.hilu0318.mapper.Admin";
	
	@Override
	public int totalMessage() throws Exception {
		return session.selectOne(namespace+".totalMessage");
	}

	@Override
	public List<MessageVO> inquireMessageList(int start, int nop) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("nop", nop);
		return session.selectList(namespace+".inquireMessageList", map);
	}

	@Override
	public void insertMessage(MessageDTO dto) throws Exception {
		session.insert(namespace+".insertMessage", dto);
	}
}
