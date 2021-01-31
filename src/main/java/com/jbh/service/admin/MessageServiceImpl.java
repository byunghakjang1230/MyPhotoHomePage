package com.jbh.service.admin;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jbh.dao.MessageDAO;
import com.jbh.domain.admin.MessageDTO;
import com.jbh.domain.admin.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDAO dao;
	
	@Override
	public int totalMessage() throws Exception {
		return dao.totalMessage();
	}

	@Override
	public List<MessageVO> inquireMessageList(int start, int nop) throws Exception {
		return dao.inquireMessageList(start, nop);
	}

	@Override
	public void insertMessage(MessageDTO dto) throws Exception {
		dao.insertMessage(dto);
	}

}
