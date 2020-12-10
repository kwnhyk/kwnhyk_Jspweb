package Lecture.Evaluation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lecture.Evaluation.dao.ArticleFileDao;
import Lecture.Evaluation.dao.BoardDao;
import Lecture.Evaluation.service.ArticleFileService;
@Service
public class ArticleFileServiceImpl implements ArticleFileService{

	
	@Autowired
	BoardDao boardDao;
	ArticleFileDao articleDao;
	   	
	 
	 // 첨부파일 목록
	    @Override
	    public List<String> getArticleFiles(Integer bno) throws Exception {
	        return articleDao.getArticleFiles(bno);
	    }

}