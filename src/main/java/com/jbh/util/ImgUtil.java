package com.jbh.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;


import org.springframework.web.multipart.MultipartFile;

import com.jbh.domain.admin.RegistPhotoInfoDTO;
import com.jbh.domain.admin.TempImgNamesVO;

public class ImgUtil {
	
	public static List<TempImgNamesVO> makeTempFileReturnNamesVO(String tempPath, List<MultipartFile> list) throws IOException{
		List<TempImgNamesVO> volist = new ArrayList<>();
		UUID newid = null;
		String dirname = tempPath + File.separator;
		makeDir(dirname);
		for(MultipartFile file : list) {
			TempImgNamesVO vo = new TempImgNamesVO();
			byte[] in = file.getBytes();
			newid = UUID.randomUUID();
			String filename = newid.toString() + file.getOriginalFilename();
			String thumbname = "s_"+newid.toString() + file.getOriginalFilename();
			
			File outfile = new File(dirname + File.separator + filename);
			FileCopyUtils.copy(in, outfile);
				
			BufferedImage bi = ImageIO.read(outfile);
			
			int width = Math.min(bi.getWidth(), bi.getHeight());
			BufferedImage cropimg = Scalr.crop(bi, (bi.getWidth()-width)/2, (bi.getHeight() - width)/2, width, width, null);
			BufferedImage newBi = Scalr.resize(cropimg, 500, 500, null);

			File thumbout = new File(dirname + File.separator + thumbname);
			String fileformat = thumbname.substring(thumbname.lastIndexOf(".")+1);
			ImageIO.write(newBi, fileformat, thumbout);

			vo.setFilename(filename);
			vo.setThumbname(thumbname);
			volist.add(vo);
		}
		return volist;		
	}

	public static void registFile(String filePath, String tempPath, RegistPhotoInfoDTO dto) throws IOException{
		String maindir = filePath + File.separator + dto.getMaincate();
		String subdir = maindir + File.separator + dto.getSubcate();
		makeDir(maindir, subdir);
		
		File infile = new File(tempPath + File.separator + dto.getFilename());
		File inthumb = new File(tempPath + File.separator + dto.getThumbname());
		File outfile = new File(subdir + File.separator + dto.getFilename());
		File outthumb = new File(subdir + File.separator + dto.getThumbname());
				
		FileCopyUtils.copy(infile, outfile);
		FileCopyUtils.copy(inthumb, outthumb);
		
	}
	
	public static boolean deleteImageFile(String filePath, String filename) {
		String fileFullName = filePath + File.separator + filename;
		File file = new File(fileFullName);
		if(file.exists()) {
			file.delete();
			if(file.exists())
				return false;
			else
				return true;
		}else {
			return true;
		}
	}
	
	public static void makeDir(String...path) {
		for(String dirpath : path) {
			File file = new File(dirpath);
			if(!file.exists()) {
				file.mkdirs();
			}
		}
	}
	
	public static void emptyTempDir(String tempPath) {
		while(true) {
			File temp = new File(tempPath);
			File[] list = temp.listFiles();
			for(File file : list) {
				file.delete();
			}
			File[] newlist = temp.listFiles();
			if(newlist.length == 0)
				break;
		}
	}
}
