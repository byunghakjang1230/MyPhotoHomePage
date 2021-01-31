package com.jbh.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jbh.domain.admin.ModifyPhotoDTO;
import com.jbh.domain.admin.RegistPhotoInfoDTO;
import com.jbh.domain.admin.TempImgNamesDTO;
import com.jbh.domain.admin.TempImgNamesVO;
import com.jbh.domain.main.PhotosVO;
import com.jbh.service.admin.PhotoService;
import com.jbh.util.ImgUtil;

@RestController
@RequestMapping("/ir")
public class ImageRegistControllerRest {
	
	@Resource(name="tempPath")
	private String tempPath;
	
	@Resource(name="filePath")
	private String filePath;
	
	@Inject
	private PhotoService service;

	@ResponseBody
	@RequestMapping(value="/temp", method=RequestMethod.POST)
	public ResponseEntity<List<TempImgNamesVO>> imgUpload(
			MultipartHttpServletRequest mhsr
			){
		List<MultipartFile> filelist = mhsr.getFiles("imgfile");
		try {
			return new ResponseEntity<>(
					ImgUtil.makeTempFileReturnNamesVO(tempPath, filelist), 
					HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/del", method = RequestMethod.POST)
	public ResponseEntity<String> imgDelete(@RequestBody TempImgNamesDTO dto){
		if(ImgUtil.deleteImageFile(tempPath, dto.getThumbname()) && ImgUtil.deleteImageFile(tempPath, dto.getFilename())) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/del/{no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> imgDelete(@PathVariable("no") int no){
		try {
			service.deleteImage(no, filePath);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="/reg", method = RequestMethod.POST)
	public ResponseEntity<String> imgRegist(@RequestBody List<RegistPhotoInfoDTO> dtolist){
		try {
			service.insertService(dtolist, filePath, tempPath);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/mod", method = RequestMethod.PUT)
	public ResponseEntity<String> imgModify(@RequestBody List<ModifyPhotoDTO> dtolist){
		try {
			service.modifyPhotolist(dtolist);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/ct", method=RequestMethod.GET)
	public ResponseEntity<List<String>> maincateInquire(){
		try {
			return new ResponseEntity<>(service.inquireMaincate(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/ct/{maincate}", method=RequestMethod.GET)
	public ResponseEntity<List<String>> subcateInquire(@PathVariable("maincate") String maincate){
		try {
			return new ResponseEntity<>(service.inquireSubcate(maincate), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/ct/{maincate}/{subcate}", method=RequestMethod.GET)
	public ResponseEntity<List<PhotosVO>> imgListInquire(@PathVariable("maincate") String maincate, @PathVariable("subcate") String subcate){
		try {
			return new ResponseEntity<>(service.inpuirePhotolist(maincate, subcate), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
	public ResponseEntity<String> tempDirInitProc(){
		ImgUtil.emptyTempDir(tempPath);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
}
