package Lecture.Evaluation.service;

import java.util.List;

public interface ArticleFileService {

	  // 첨부파일 목록
    List<String> getArticleFiles(Integer bno) throws Exception;
    
}
