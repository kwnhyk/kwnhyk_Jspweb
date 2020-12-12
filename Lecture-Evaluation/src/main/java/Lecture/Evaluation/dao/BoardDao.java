package Lecture.Evaluation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import Lecture.Evaluation.domain.BoardDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.SearchCriteria;

public interface BoardDao {
	// 첨부파일 삭제
	public void deleteFile(@Param("fileName") String fileName) throws Exception;

	// 첨부파일 수정
	public void replaceFile(@Param("fileName")String fileName,@Param("bno") Integer bno) throws Exception;

	// 첨부파일 개수 갱신
	public void updateFileCnt(Integer bno) throws Exception;
	//첨부파일 다삭제
	public void deleteFiles(Integer bno) throws Exception;
	public List<String> getArticleFiles(Integer bno) throws Exception;
	public void addFile(String fullName) throws Exception;
	public void create(BoardDTO vo) throws Exception;
	public BoardDTO read(Integer bno) throws Exception;
	public void update(BoardDTO vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public void increaseViewcnt(Integer bno) throws Exception;
	public List<BoardDTO> findAll() throws Exception;
	public int countArticles(Criteria criteria) throws Exception ;
	public List<BoardDTO> listCriteria(Criteria criteria) throws Exception;	
	public List<BoardDTO> listSearch(SearchCriteria searchCriteria) throws Exception;
	public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
	


}
