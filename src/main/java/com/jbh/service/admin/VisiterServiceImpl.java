package com.jbh.service.admin;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jbh.dao.VisiterDAO;
import com.jbh.domain.admin.VisiterPositionVO;

@Service
public class VisiterServiceImpl implements VisiterService {

	@Inject
	private VisiterDAO dao;
	
	@Override
	public List<VisiterPositionVO> totalPosition() throws Exception {
		return dao.totalPosition();
	}

	@Override
	public Map<String, Object> inquireVisiterST(String date) throws Exception {
		Calendar cal = Calendar.getInstance();
		Map<String, Object> map = new HashMap<>();
		
		String year = cal.get(Calendar.YEAR)+"";
		String month = year+"-"+(cal.get(Calendar.MONTH)+1);
		String day = month + "-" + cal.get(Calendar.DATE);
		
		if(date.equals("d")) {
			map.put("visiter", dao.inquireVisiterST(day));
			map.put("count", dao.inquireCount(day));
			return map;
		}else if(date.equals("m")) {
			map.put("visiter", dao.inquireVisiterST(month));
			map.put("count", dao.inquireCount(month));
			return map;
		}else if(date.equals("y")) {
			map.put("visiter", dao.inquireVisiterST(year));
			map.put("count", dao.inquireCount(year));
			return map;
		}else if(date.equals("t")) {
			map.put("visiter", dao.inquireVisiterST("0"));
			map.put("count", dao.inquireCount("0"));
			return map;
		}else {
			return null;
		}
	}
}
