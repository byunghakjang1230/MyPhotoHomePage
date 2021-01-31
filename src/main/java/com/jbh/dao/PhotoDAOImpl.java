package com.jbh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jbh.domain.admin.ModifyPhotoDTO;
import com.jbh.domain.admin.RegistPhotoInfoDTO;
import com.jbh.domain.main.PhotosVO;

@Repository
public class PhotoDAOImpl implements PhotoDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.hilu0318.mapper.Photo";
	
	@Override
	public int totalImage() throws Exception {
		return session.selectOne(namespace+".totalImage");
	}

	@Override
	public List<String> inquireMainBGI() throws Exception {
		return session.selectList(namespace+".inquireMainBGI");
	}

	@Override
	public void insertImageFile(RegistPhotoInfoDTO dto) throws Exception {
		session.insert(namespace+".insertImageFile", dto);
	}

	@Override
	public List<String> inquireMaincate() throws Exception {
		return session.selectList(namespace+".inquireMaincate");
	}

	@Override
	public List<String> inquireSubcate(String maincate) throws Exception {
		return session.selectList(namespace+".inquireSubcate", maincate);
	}

	@Override
	public List<PhotosVO> inpuirePhotolist(String maincate, String subcate) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("maincate", maincate);
		map.put("subcate", subcate);
		return session.selectList(namespace+".inpuirePhotolist", map);
	}

	@Override
	public void updateImageInfo(ModifyPhotoDTO dto) throws Exception {
		session.update(namespace+".updateImageInfo", dto);
	}

	@Override
	public void deleteImage(int no) throws Exception {
		session.delete(namespace+".deleteImage", no);
	}

	@Override
	public PhotosVO inpuirePhoto(int no) throws Exception {
		return session.selectOne(namespace+".inpuirePhoto", no);
	}

}
