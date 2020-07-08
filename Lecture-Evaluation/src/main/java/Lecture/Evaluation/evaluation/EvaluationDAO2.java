package Lecture.Evaluation.evaluation;

import Lecture.Evaluation.util.DatabaseUtil;
import java.util.List;

public interface EvaluationDAO2 {

 int write(EvaluationDTO evaluationDTO) throws Exception;
		
	
	
	default ArrayList<EvaluationDTO> getList(String lectureDivide,String searchType,String search ,int pageNumber)
			throws Exception
	{
	return null;
	}
	 int like(int evaluationID)throws Exception; 
		
	
	
 int delete(int evaluationID) throws Exception;
		
		
	
 String getUserID(int evaluationID) throws Exception;
	
	

}
