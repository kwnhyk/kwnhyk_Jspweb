package Lecture.Evaluation.dao;


import java.util.List;
import java.util.Map;

import Lecture.Evaluation.domain.EvaluationDTO;

public interface EvaluationDao {

public int insert(EvaluationDTO evaluationDTO) throws Exception;
		public List<EvaluationDTO> findAll() throws Exception;
	
	
	
	
	
	public List<EvaluationDTO> getList(Map<String, Object> params)
			throws Exception;
	
	
	public int updateLike(int evaluationID)throws Exception; 
		
	
	
	public int delete(int evaluationID) throws Exception;
		
		
	
	public EvaluationDTO findByevaluationId(int evaluationID) throws Exception;
	
	public int listSearchCount(int evaluationID) throws Exception;
	

}
