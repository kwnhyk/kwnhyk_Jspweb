package Lecture.Evaluation.web;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Lecture.Evaluation.service.BoardService;
import Lecture.Evaluation.util.UploadFileUtils;

@RestController
@RequestMapping("/board/file")
public class ArticleFileController {


	@Autowired
	BoardService boardService;

    // 게시글 파일 업로드
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> uploadFile(MultipartFile file, HttpServletRequest request) {
        ResponseEntity<String> entity = null;
        try {
            String savedFilePath = UploadFileUtils.uploadFile(file, request);
            entity = new ResponseEntity<>(savedFilePath, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
    
 // 게시글 첨부파일 출력
    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public ResponseEntity<byte[]> displayFile(String fileName, HttpServletRequest request) throws Exception {

        HttpHeaders httpHeaders = UploadFileUtils.getHttpHeaders(fileName); // Http 헤더 설정 가져오기
        String rootPath = UploadFileUtils.getRootPath(fileName, request); // 업로드 기본경로 경로

        ResponseEntity<byte[]> entity = null;

        // 파일데이터, HttpHeader 전송
        try (InputStream inputStream = new FileInputStream(rootPath + fileName)) {
            entity = new ResponseEntity<>(IOUtils.toByteArray(inputStream), httpHeaders, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

}