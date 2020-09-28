package Lecture.Evaluation.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.logging.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {

	private static final Logger logger =LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(MultipartFile file,HttpServletRequest request)throws Exception{
		
	String originalFileName = file.getOriginalFilename();
	byte[] fileDate = file.getBytes();
	
	String uuidFileName = getUuidFileName(originalFileName);
	
	String rootPath = getRootPath(originalFileName, request);
	String datePath = getDatePath(rootPath);
	
	File target = new FIle(rootPath + datePath,uuidFileName);
	FileCopyUtils.copy(fileDate, target);
	
	if(MediaUtils.getMediaType(originalFileName) != null) {
		uuidFileName = makeThumbnail(rootPath,datePath,uuidFileName);
		
	}
	
	return replaceSavedFilePath(datePath, uuidFileName);
		
		
		
	}
	public static void deleteFile(String fileName,HttpServletRequest request) {
		String rootPath = getRootPath(fileName,request);
		MediaType mediaType = MediaUtils.getMediaType(fileName);
		if(mediaType !=null) {
			String originalImg = fileName.substring(0,12)+fileName.substring(14);
			new File(rootPath+originalImg.replace('/', File.separatorChar)).delete();
			
		}
		new File(rootPath +fileName.replace('/', File.separatorChar)).delete();
	}
	public static HttpHeaders getHttpHeaders(String fileName)throws Exception{
		
		
		MediaType mediaType = MediaUtills.getMediaType(fileName);
		HttpHeaders httpHeaders = new HttpHeaders();
		
		if(mediaType !=null) {
			httpHeaders.setContentType(mediaType);
			return httpHeaders;
		}
		fileName = fileName.substring(fileName.indexOf("_")+1);
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		
		}
	}
}
