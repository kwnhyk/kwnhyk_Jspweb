package Lecture.Evaluation.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Lecture.Evaluation.domain.EvaluationDTO;
import Lecture.Evaluation.service.EvaluationService;
import Lecture.Evaluation.service.UserService;
import Lecture.Evaluation.user.UserDTO;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	EvaluationService evaluationService;
	
	    
	   @GetMapping("form")
	    public String list(HttpSession session) throws Exception {
		   String lectureDivide = "전체";
	    	String searchType = "최신순";
	    	String search = "";
	    	int pageNumber =0;
	      List<EvaluationDTO> evalList = evaluationService.list(lectureDivide,searchType,search,pageNumber);
	      if (evalList != null) {
	        System.out.println("수업목록==========>" + evalList);
	        session.setAttribute("evalList", evalList);
	      }
	      return "/WEB-INF/jsp/evaluation/form.jsp";
	    }
	    


	  
	

	
	
}
