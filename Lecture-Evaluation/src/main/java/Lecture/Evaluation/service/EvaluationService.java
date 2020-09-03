package Lecture.Evaluation.service;


import java.util.List;
import java.util.Map;

import Lecture.Evaluation.domain.BoardDTO;
import Lecture.Evaluation.domain.EvaluationDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.SearchCriteria;



public interface EvaluationService {

	
	
	List<EvaluationDTO> list(String lectureDivide,String searchType,String search ) throws Exception ;
	
 int write(EvaluationDTO evaluationDTO) throws Exception;
		List<EvaluationDTO> getAll()throws Exception;
	
	List<EvaluationDTO> listCriteria(Criteria criteria)throws Exception;
	 List<EvaluationDTO> listSearch(SearchCriteria searchCriteira) throws Exception;
	
	
	
	
	 int like(int evaluationID)throws Exception; 
		
	
	
	 int delete(int evaluationID) throws Exception;
		
		
	 int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
	 String getUserID(int evaluationID) throws Exception;
	
	 int listCount(Criteria criteria) throws Exception;
	
	
}
