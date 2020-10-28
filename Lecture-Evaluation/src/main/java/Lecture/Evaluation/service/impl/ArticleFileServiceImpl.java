package Lecture.Evaluation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Lecture.Evaluation.dao.ArticleFileDao;
import Lecture.Evaluation.dao.BoardDao;
import Lecture.Evaluation.service.ArticleFileService;

public class ArticleFileServiceImpl implements ArticleFileService{


	@Autowired
	BoardDao boardDao;
	ArticleFileDao articleFileDao;
	   
	    public ArticleFileServiceImpl(ArticleFileDao articleFileDao) {
	        this.articleFileDao = articleFileDao;
	    }
	 // 첨부파일 목록
	    @Override
	    public List<String> getArticleFiles(Integer articleNo) throws Exception {
	        return articleFileDao.getArticleFiles(articleNo);
	    }

}