package Lecture.Evaluation.dao;

import Lecture.Evaluation.util.DatabaseUtil;
import java.util.List;

public interface EvaluationDAO2 {

public int insert(EvaluationDTO evaluationDTO) throws Exception;
		
	
	
	default List<EvaluationDTO> getList(Map<String, Object> params)
			throws Exception
	{
	return null;
	}
	public int like(int evaluationID)throws Exception; 
		
	
	
public int delete(int evaluationID) throws Exception;
		
		
	
public EvaluationDTO getUserID(int evaluationID) throws Exception;
	
	

}
