package Lecture.Evaluation.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Lecture.Evaluation.dao.ArticleFileDao;
import Lecture.Evaluation.dao.BoardDao;
import Lecture.Evaluation.domain.BoardDTO;
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.SearchCriteria;
import Lecture.Evaluation.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao boardDao;
	
	
	
	@Transactional
	@Override
	public void insert(BoardDTO vo) throws Exception {
		 String title = vo.getTitle();
	        String content = vo.getContent();
	     
	      // *태그문자 처리 (< ==> &lt; > ==> &gt;)
	        // replace(A, B) A를 B로 변경
	      title = title.replace("<", "&lt;");
	        title = title.replace("<", "&gt;");
	     
	        // *공백문자 처리
	        title = title.replace("  ",    "&nbsp;&nbsp;");
	     
	        // *줄바꿈 문자처리
	       content = content.replace("\n", "<br>");
	      vo.setTitle(title);
	        vo.setContent(content);
	       
	        
	      String[] files = vo.getFiles();
	      if(files == null) {
	    	  boardDao.create(vo);
	    	  return;
	      }
	      vo.setFileCnt(files.length);
	      boardDao.create(vo);
	      for(String fileName :files) {
	    	  
	    	  boardDao.addFile(fileName);
	    	  
		
	}
	      System.out.println("들어갔니?");
	}

	@Override
	public BoardDTO read(Integer bno) throws Exception {
	    return boardDao.read(bno);
	}

	@Override
	public void update(BoardDTO vo) throws Exception {
		 boardDao.update(vo);
		
	}

	@Override
	public void delete(Integer bno) throws Exception {
		boardDao.delete(bno);
		
	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return boardDao.findAll();
	}

	@Override
	public void increaseViewcnt(Integer bno, HttpSession session) throws Exception {

		 long update_time = 0;
	        // 세션에 저장된 조회시간 검색
	        // 최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행X
	        if(session.getAttribute("update_time_"+bno) != null){
	                                // 세션에서 읽어오기
	            update_time = (long)session.getAttribute("update_time_"+bno);
	        }
	        // 시스템의 현재시간을 current_time에 저장
	        long current_time = System.currentTimeMillis();
	        // 일정시간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간)
	        // 시스템현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
	        if(current_time - update_time > 5*1000){
	           boardDao.increaseViewcnt(bno);
	            // 세션에 시간을 저장 : "update_time_"+bno는 다른변수와 중복되지 않게 명명한 것
	            session.setAttribute("update_time_"+bno, current_time);
	            
	        }
			
	    }
	@Override
	public List<BoardDTO> listCriteria(Criteria criteria) throws Exception {
		return boardDao.listCriteria(criteria);
	}
	@Override
	public int countBoard(Criteria criteria) throws Exception {
		 return boardDao.countArticles(criteria);
	}
	@Override
	public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception {
		
		return boardDao.countSearchedArticles(searchCriteria);
	}
	@Override
	public List<BoardDTO> listSearch(SearchCriteria searchCriteria) throws Exception {
		return boardDao.listSearch(searchCriteria);
	}
	
	}


