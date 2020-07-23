package Lecture.Evaluation.service;


import java.util.List;
import java.util.Map;

import Lecture.Evaluation.domain.EvaluationDTO;



public interface EvaluationService {

	
	
	List<EvaluationDTO> list(String lectureDivide,String searchType,String search ,int pageNumber) throws Exception ;
	
 int write(EvaluationDTO evaluationDTO) throws Exception;
		
	
	
	
	
	
	
	
	 int like(int evaluationID)throws Exception; 
		
	
	
	 int delete(int evaluationID) throws Exception;
		
		
	
	 EvaluationDTO getUserID(int evaluationID) throws Exception;
	
	 int listSearchCount(int evaluationID) throws Exception;
	
	
}
