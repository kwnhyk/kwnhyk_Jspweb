package Lecture.Evaluation.dao;

import java.util.List;

public interface ArticleFileDao {

	void addFile(String fileName) throws Exception;
	// 첨부 파일 목록
	List<String> getArticleFiles(Integer articleNo) throws Exception;

	
}
