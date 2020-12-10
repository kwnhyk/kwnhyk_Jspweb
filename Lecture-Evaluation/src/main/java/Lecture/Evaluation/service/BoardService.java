package Lecture.Evaluation.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import Lecture.Evaluation.domain.BoardDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.SearchCriteria;

public interface BoardService {

		//게시글 작성
	    public void insert(BoardDTO vo) throws Exception;
	    //  게시글 상세보기
	    public BoardDTO read(Integer bno) throws Exception;
	    //  게시글 수정
	    public void update(BoardDTO vo) throws Exception;
	    //  게시글 삭제
	    public void delete(Integer bno) throws Exception;
	    // 게시글 전체 목록
	    public List<BoardDTO> listAll() throws Exception;
	    //  게시글 조회
	    public void increaseViewcnt(Integer bno, HttpSession session) throws Exception;
	   public int countBoard(Criteria criteria) throws Exception;
	   public List<BoardDTO> listCriteria(Criteria criteria) throws Exception;
	   List<BoardDTO> listSearch(SearchCriteria searchCriteira) throws Exception;
	    // 첨부파일 목록
	   public List<String> getArticleFiles(Integer bno) throws Exception;
	 
	   int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
	   


}
