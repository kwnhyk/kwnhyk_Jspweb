package Lecture.Evaluation.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Lecture.Evaluation.domain.EvaluationDTO;
import Lecture.Evaluation.domain.UserDTO;
import Lecture.Evaluation.service.EvaluationService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	EvaluationService evaluationService;
	

	  
	   @GetMapping("list")
	    public String list(Model model) throws Exception {
		   List<EvaluationDTO> evalAll = evaluationService.getAll();
		   
			   
		 
		   String lectureDivide = "전체";
	    	String searchType = "최신순";
	    	String search = "";
	    		
			   if(lectureDivide=="전체") {
				   
				   System.out.println("수업목록 =====>"+evalAll);
				   model.addAttribute("evalAll",evalAll);
				   
			   }
			   System.out.println("evalAll==" +evalAll);
			  
			
	    //  List<EvaluationDTO> evalList = evaluationService.list(lectureDivide,searchType,search);
	   //   if (evalList != null) {
	     //  System.out.println("수업목록==========>" + evalList);
	     //  model.addAttribute("evalList", evalList);
	   
	   
	 //   }
	   return "/WEB-INF/jsp/evaluation/list.jsp";
	   }
	    @PostMapping("write")
	    public String write(HttpSession session,@ModelAttribute("evalDTO") EvaluationDTO eval,Model model) throws Exception{
	    	int result=-1;
	    	
	    	String writer = (String) session.getAttribute("loginUser");
	    	 System.out.println("유저"+writer);
	    	eval.setUserID(writer);
	    	
	    	result=evaluationService.write(eval);
	    	System.out.println("result"+result);
	    	if(result==-1) {
	    		model.addAttribute("error",1);
	    		return "/app/evaluation/list";
	    	}
	    	else { 
	    		
	    		
	    		return "redirect:list";
	    	}
	    	
	    }

	   
	  
	

	
	
}
