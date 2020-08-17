package Lecture.Evaluation.dao;

import java.util.List;


import Lecture.Evaluation.domain.BoardDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.SearchCriteria;

public interface BoardDao {

	
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
