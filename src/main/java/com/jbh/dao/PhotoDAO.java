package com.jbh.dao;

import java.util.List;

import com.jbh.domain.admin.ModifyPhotoDTO;
import com.jbh.domain.admin.RegistPhotoInfoDTO;
import com.jbh.domain.main.PhotosVO;

public interface PhotoDAO {

	public int totalImage() throws Exception;
	
	public List<String> inquireMainBGI()throws Exception;
	
	public void insertImageFile(RegistPhotoInfoDTO dto)throws Exception;
	
	public List<String> inquireMaincate()throws Exception;
	
	public List<String> inquireSubcate(String maincate)throws Exception;
	
	public PhotosVO inpuirePhoto(int no)throws Exception;
	
	public List<PhotosVO> inpuirePhotolist(String maincate, String subcate)throws Exception;
	
	public void updateImageInfo(ModifyPhotoDTO dto)throws Exception;
	
	public void deleteImage(int no)throws Exception;
	
	
}
