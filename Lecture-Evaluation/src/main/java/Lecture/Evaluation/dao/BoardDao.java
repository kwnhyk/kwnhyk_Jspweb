package Lecture.Evaluation.dao;

import java.util.List;


import Lecture.Evaluation.domain.BoardVO;

public interface BoardDao {

	
	public int create(BoardVO vo) throws Exception;
	public  BoardVO read(int bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	public double increaseViewcnt(int bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;

}
