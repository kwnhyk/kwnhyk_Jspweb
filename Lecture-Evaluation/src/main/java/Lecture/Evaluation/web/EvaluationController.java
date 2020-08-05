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
	    public ModelAndView list(HttpSession session,@RequestParam(defaultValue="")String lectureDivide,
	    		@RequestParam(defaultValue="최신순")String searchType,@RequestParam(defaultValue="")String search) throws Exception {
		   String user =(String) session.getAttribute("loginUser");
			 if(user !=null) {
			    
				
			
		   if(lectureDivide.equals("전체")) {
			   lectureDivide ="";
		   	 }
		   // List<EvaluationDTO> evalAll = evaluationService.getAll();
		  
			   List<EvaluationDTO> list = evaluationService.list(lectureDivide,searchType,search);
		   
		   ModelAndView mav = new ModelAndView();
		   
		   Map<String,Object> map = new HashMap<String,Object>();
		   map.put("list", list);
		   map.put("lectureDivide", lectureDivide);
		   map.put("searchType", searchType);
		   map.put("search", search);
		   mav.addObject("map", map);
		   mav.setViewName("evaluation/list");
		   System.out.println("이게 바로셀렉");
		   System.out.println("map==" +map);
		   return mav;
			 }else
			 {
				 String url = "redirect:../auth/form";
			        return new ModelAndView(url);
				 
			 }
			 //  if(lectureDivide.equals("전체")){
				 //  lectureDivide ="";
				//   System.out.println("수업목록 =====>"+evalAll);
				   
				   
			   
			  // }  
			 
			  
			
			 
	   //   if (evalList != null) {
	     //  System.out.println("수업목록==========>" + evalList);
	     //  model.addAttribute("evalList", evalList);
	   
	   
	 //   }
	  
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
