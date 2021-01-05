package Lecture.Evaluation.dao;

import java.util.List;

import Lecture.Evaluation.domain.ReplyDTO;

public interface ReplyDao {

	List<ReplyDTO> list(Integer bno) throws Exception;
	void create(ReplyDTO replyDTO) throws Exception;
	void update(ReplyDTO replyDTO) throws Exception;
	void delete(Integer bno) throws Exception;
	
}
