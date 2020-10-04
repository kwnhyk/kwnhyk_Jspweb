package Lecture.Evaluation.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

import javax.imageio.ImageIO;
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
		
		httpHeaders.add("Content-Dispostion", "attachment);filename=\""+new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\"");
		return httpHeaders;
		}
	public static String getRootPath(String fileName, HttpServletRequest request) {
		String rootPath = "/resources/upload";
		MediaType mediaType = MediaUtils.getMediaType(fileName);
		if(mediaType !=null)
			return request.getSession().getServletContext().getRealPath(rootPath+ "/images");
		return request.getSession().getServletContext().getRealPath(rootPath+"/files");
		
	
	}
	 private static String getDatePath(String uploadPath) {

	        Calendar calendar = Calendar.getInstance();
	        String yearPath = File.separator + calendar.get(Calendar.YEAR);
	        String monthPath = yearPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.MONTH) + 1);
	        String datePath = monthPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.DATE));

	        makeDateDir(uploadPath, yearPath, monthPath, datePath);

	        return datePath;
	    }
	// 날짜별 폴더 생성
	    private static void makeDateDir(String uploadPath, String... paths) {

	        // 날짜별 폴더가 이미 존재하면 메서드 종료
	        if (new File(uploadPath + paths[paths.length - 1]).exists())
	            return;

	        for (String path :  paths) {
	            File dirPath = new File(uploadPath + path);
	            if (!dirPath.exists())
	                dirPath.mkdir();

	        }
	    }

	    // 파일 저장 경로 치환
	    private static String replaceSavedFilePath(String datePath, String fileName) {
	        String savedFilePath = datePath + File.separator + fileName;
	        return savedFilePath.replace(File.separatorChar, '/');
	    }

	    // 파일명 중복방지 처리
	    private static String getUuidFileName(String originalFileName) {
	        return UUID.randomUUID().toString() + "_" + originalFileName;
	    }

	    // 썸네일 이미지 생성
	    private static String makeThumbnail(String uploadRootPath, String datePath, String fileName) throws Exception {

	        // 원본이미지를 메모리상에 로딩
	        BufferedImage originalImg = ImageIO.read(new File(uploadRootPath + datePath, fileName));
	        // 원본이미지를 축소
	        BufferedImage thumbnailImg = Scalr.resize(originalImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
	        // 썸네일 파일명
	        String thumbnailImgName = "s_" + fileName;
	        // 썸네일 업로드 경로
	        String fullPath = uploadRootPath + datePath + File.separator + thumbnailImgName;
	        // 썸네일 파일 객체생성
	        File newFile = new File(fullPath);
	        // 썸네일 파일 확장자 추출
	        String formatName = MediaUtils.getFormatName(fileName);
	        // 썸네일 파일 저장
	        ImageIO.write(thumbnailImg, formatName, newFile);

	        return thumbnailImgName;
	    }

	}

