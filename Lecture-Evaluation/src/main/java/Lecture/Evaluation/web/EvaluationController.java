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
import Lecture.Evaluation.domain.UserDTO;
import Lecture.Evaluation.service.EvaluationService;
import Lecture.Evaluation.service.UserService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	EvaluationService evaluationService;
	@Autowired
	UserService userService;

	    
	   @GetMapping("list")
	    public String list(Model model) throws Exception {
		   String lectureDivide = "전체";
	    	String searchType = "최신순";
	    	String search = "";
	    	int pageNumber =0;
	    	
	      List<EvaluationDTO> evalList = evaluationService.list(lectureDivide,searchType,search,pageNumber);
	      if (evalList != null) {
	       System.out.println("수업목록==========>" + evalList);
	       model.addAttribute("evalList", evalList);
	     }
	      return "/WEB-INF/jsp/evaluation/list.jsp";
	    }
	    @PostMapping("write")
	    public String write(HttpSession session,EvaluationDTO evaluationDTO,UserDTO userID,Model model) throws Exception{
	    	int result=-1;
	    	 
	    	
	    	session.getAttribute("loginUser");
	    	
	    	result=evaluationService.write(evaluationDTO);
	    	if(result==-1) {
	    		model.addAttribute("error",1);
	    		return "/app/evaluation/list";
	    	}
	    	else { 
	    		
	    		
	    		return "redirect:list";
	    	}
	    	
	    }

	   
	  
	

	
	
}
