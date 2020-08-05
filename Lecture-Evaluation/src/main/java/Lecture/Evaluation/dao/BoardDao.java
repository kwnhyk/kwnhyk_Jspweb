package Lecture.Evaluation.dao;

import java.util.List;


import Lecture.Evaluation.domain.BoardDTO;

public interface BoardDao {

	
	public void create(BoardDTO vo) throws Exception;
	public BoardDTO read(Integer bno) throws Exception;
	public void update(BoardDTO vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public void increaseViewcnt(Integer bno) throws Exception;
	public List<BoardDTO> findAll() throws Exception;

}
