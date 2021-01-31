package com.jbh.service.admin;

import java.util.List;

import com.jbh.domain.admin.ModifyPhotoDTO;
import com.jbh.domain.admin.RegistPhotoInfoDTO;
import com.jbh.domain.main.PhotosVO;

public interface PhotoService {
	
	public void insertService(List<RegistPhotoInfoDTO> dtolist, String filePath, String tempPath)throws Exception;
	
	public List<String> inquireMaincate()throws Exception;
	
	public List<String> inquireSubcate(String maincate)throws Exception;
	
	public List<PhotosVO> inpuirePhotolist(String maincate, String subcate)throws Exception;
	
	public void modifyPhotolist(List<ModifyPhotoDTO> dtolist)throws Exception;
	
	public void deleteImage(int no, String filePath)throws Exception;
	
}