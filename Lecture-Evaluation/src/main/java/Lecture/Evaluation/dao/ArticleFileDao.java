package Lecture.Evaluation.dao;

import java.util.List;

public interface ArticleFileDao {

	void addFile(String fullName) throws Exception;
	// 첨부 파일 목록
	List<String> getArticleFiles(Integer bno) throws Exception;
	void deleteFiles(Integer bno) throws Exception;
	
}
