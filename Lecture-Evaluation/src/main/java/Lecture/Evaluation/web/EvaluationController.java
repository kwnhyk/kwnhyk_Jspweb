package Lecture.Evaluation.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Lecture.Evaluation.domain.EvaluationDTO;
import Lecture.Evaluation.domain.UserDTO;
import Lecture.Evaluation.service.EvaluationService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	EvaluationService evaluationService;
	

	  
	   @RequestMapping("list")
	    public ModelAndView list(EvaluationDTO eval,@RequestParam(defaultValue="전체")String lectureDivide,
	    		@RequestParam(defaultValue="최신순")String searchType,@RequestParam(defaultValue="")String search) throws Exception {
		 
		   if(lectureDivide.equals("전체")) {
			   lectureDivide ="";
		   }		 
		   // List<EvaluationDTO> evalAll = evaluationService.getAll();
		   List<EvaluationDTO> list = evaluationService.list(lectureDivide,searchType,search);
		   
		   ModelAndView mav = new ModelAndView();
		   
		   Map<String,Object> map = new HashMap<String,Object>();
		   map.put("list", list);
		   map.put("lectrueDivide", lectureDivide);
		   map.put("searchType", searchType);
		   map.put("search", search);
		   mav.addObject("map", map);
		   mav.setViewName("evaluation/list");
		   
			 //  if(lectureDivide.equals("전체")){
				 //  lectureDivide ="";
				//   System.out.println("수업목록 =====>"+evalAll);
				   
				   
			   
			  // }  
			   System.out.println("map==" +map);
			  
			
			 
	   //   if (evalList != null) {
	     //  System.out.println("수업목록==========>" + evalList);
	     //  model.addAttribute("evalList", evalList);
	   
	   
	 //   }
	   return mav;
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
