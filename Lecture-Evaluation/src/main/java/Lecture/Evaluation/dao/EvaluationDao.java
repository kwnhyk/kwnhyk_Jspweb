package Lecture.Evaluation.dao;

import Lecture.Evaluation.evaluation.EvaluationDTO;
import java.util.List;
import java.util.Map;

public interface EvaluationDao {

public int insert(EvaluationDTO evaluationDTO) throws Exception;
		
	
	
	
	public List<EvaluationDTO> getList(Map<String, Object> params)
			throws Exception;
	
	
	public int like(int evaluationID)throws Exception; 
		
	
	
	public int delete(int evaluationID) throws Exception;
		
		
	
	public EvaluationDTO getUserID(int evaluationID) throws Exception;
	
	public int listSearchCount(int evaluationID) throws Exception;
	

}
