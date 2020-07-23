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
import Lecture.Evaluation.service.UserService;
import Lecture.Evaluation.user.UserDTO;
import Team.project.domain.Clazz;
import Team.project.domain.User;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	
	
	    
	   @GetMapping("form")
	    public String list(HttpSession session) throws Exception {
	      int no = -1;
	      if (session.getAttribute("userID") != null) {
	        no = ((UserDTO) session.getAttribute("userID")).getUserID();
	      }
	      List<EvaluationDTO> evalList = evaluationService.list(no);
	      if (evalList != null) {
	        System.out.println("수업목록==========>" + evalList);
	        session.setAttribute("evalList", evalList);
	      }
	      return "/WEB-INF/jsp/evaluation/list.jsp";
	    }
	    


	  
	

	
	
}
