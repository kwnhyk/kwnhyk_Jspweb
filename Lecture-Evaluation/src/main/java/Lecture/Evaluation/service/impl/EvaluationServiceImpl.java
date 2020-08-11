package Lecture.Evaluation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import Lecture.Evaluation.dao.EvaluationDao;
import Lecture.Evaluation.domain.EvaluationDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.service.EvaluationService;

@Component
public class EvaluationServiceImpl implements EvaluationService {

	EvaluationDao evaluationDao;
	
	
	public EvaluationServiceImpl(EvaluationDao evaluationDao) {
		this.evaluationDao= evaluationDao;
	}
	@Override
	  public List<EvaluationDTO> list(String lectureDivide,String searchType,String search ) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("lectureDivide", lectureDivide);
		params.put("searchType", searchType);
		params.put("search", search);
		
	    return evaluationDao.getList(params);
	  }
	@Override
	public int delete(int evaluationID) throws Exception {

		
		return evaluationDao.delete(evaluationID);
	}
	@Override
	public int write(EvaluationDTO evaluationDTO) throws Exception {
		return evaluationDao.insert(evaluationDTO);
	}
	@Override
	public int like(int evaluationID) throws Exception {
		return evaluationDao.updateLike(evaluationID);
	}
	@Override
	public int listSearchCount(int evaluationID) throws Exception {
		return evaluationDao.listSearchCount(evaluationID);
	}@Override
	public String getUserID(int evaluationID) throws Exception {
		return evaluationDao.findByevaluationId(evaluationID);
	}
	@Override
	
	public List<EvaluationDTO> getAll() throws Exception {
		return evaluationDao.findAll();
	}
	@Override
	public List<EvaluationDTO> listCriteira(Criteria criteria) throws Exception {
		return evaluationDao.listCriteria(criteria);
	}
	
}