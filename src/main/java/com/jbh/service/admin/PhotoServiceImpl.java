package com.jbh.service.admin;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbh.dao.PhotoDAO;
import com.jbh.domain.admin.ModifyPhotoDTO;
import com.jbh.domain.admin.RegistPhotoInfoDTO;
import com.jbh.domain.main.PhotosVO;
import com.jbh.util.ImgUtil;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Inject
	private PhotoDAO dao;
	
	@Transactional
	@Override
	public void insertService(List<RegistPhotoInfoDTO> dtolist, String filePath, String tempPath) throws Exception {
		for(RegistPhotoInfoDTO dto : dtolist) {
			ImgUtil.registFile(filePath, tempPath, dto);
			dao.insertImageFile(dto);
		}
		ImgUtil.emptyTempDir(tempPath);
	}

	@Override
	public List<String> inquireMaincate() throws Exception {
		return dao.inquireMaincate();
	}

	@Override
	public List<String> inquireSubcate(String maincate) throws Exception {
		return dao.inquireSubcate(maincate);
	}

	@Override
	public List<PhotosVO> inpuirePhotolist(String maincate, String subcate) throws Exception {
		return dao.inpuirePhotolist(maincate, subcate);
	}

	@Transactional
	@Override
	public void modifyPhotolist(List<ModifyPhotoDTO> dtolist) throws Exception {
		for(ModifyPhotoDTO dto: dtolist) {
			if(dto.getChange().equals("c"))
				dao.updateImageInfo(dto);
		}
	}

	@Transactional
	@Override
	public void deleteImage(int no, String filePath) throws Exception {
		PhotosVO vo = dao.inpuirePhoto(no);
		if(vo != null) {
			String nFilePath = filePath+File.separator + vo.getMaincate() + File.separator + vo.getSubcate();
			while(true) {
				if(ImgUtil.deleteImageFile(nFilePath, vo.getThumbname()) && ImgUtil.deleteImageFile(nFilePath, vo.getFilename()))
						break;
			}
			dao.deleteImage(no);
		}
	}
}
