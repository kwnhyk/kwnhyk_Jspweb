package Lecture.Evaluation.dao;

import java.util.List;

import Lecture.Evaluation.domain.BoardVO;

public interface BoardDao {

	
	public void create(BoardVO vo) throws Exception;
	public  BoardVO read(BoardVO vo) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(BoardVO vo) throws Exception;
	public void increaseViewcnt(BoardVO vo) throws Exception;
	public List<BoardVO> listALl() throws Exception;

}
