package Lecture.Evaluation.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
import Lecture.Evaluation.page.Criteria;
import Lecture.Evaluation.page.PageMaker;
import Lecture.Evaluation.page.SearchCriteria;
import Lecture.Evaluation.service.EvaluationService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	EvaluationService evaluationService;
	
		@PostMapping("like")
		public String like(@RequestParam int evaluationID,Model model)throws Exception{
			//String result=likey.like(evalID,userID,userIP);
			//if(result=1){
			//result=evaluationService.like(evaluationID);
			//if(result=1){
			
			
			//model.addAttribute("like",1);
			//return "redirect:list";
			//}
			//}else{
			//model.addAttribute("like",2);
			//return "redirect:list";
			
			evaluationService.like(evaluationID);
			model.addAttribute("like",1);
			
			return "redirect:list";
		}
	  @PostMapping("delete")
	  public void delete(@RequestParam int evaluationID ,HttpServletResponse response ,HttpSession session)throws Exception{
		  
		  UserDTO user= (UserDTO)session.getAttribute("loginUser");
		  String userID=(String)user.getUserID();
		  System.out.printf(" id=%s",userID);
		  if(userID.equals(evaluationService.getUserID(evaluationID))) {
			  response.setStatus(200);
			  evaluationService.delete(evaluationID);
			 // return "redirect:list";
		  }else
		  {
			  
			  response.setStatus(400);
			 // return "redirect:list";
		  }
		 
		 
	  }
	   @RequestMapping("list")
	    public ModelAndView list(HttpSession session,@ModelAttribute("Criteria")Criteria criteria,@RequestParam(defaultValue="")String lectureDivide,
	    		@RequestParam(defaultValue="최신순")String searchType,@RequestParam(defaultValue="")String search) throws Exception {
		   UserDTO user =(UserDTO) session.getAttribute("loginUser");
			 if(user !=null) {
			    
				
			
		   if(lectureDivide.equals("전체")) {
			   lectureDivide ="";
		   	 }
		   PageMaker pageMaker = new PageMaker();
		   pageMaker.setCriteria(criteria);
		   pageMaker.setTotalCount(evaluationService.listCount(criteria));
		   // List<EvaluationDTO> evalAll = evaluationService.getAll();
		  
			   List<EvaluationDTO> list = evaluationService.list(lectureDivide,searchType,search);
		   
		   ModelAndView mav = new ModelAndView();
		   
		   Map<String,Object> map = new HashMap<String,Object>();
		   map.put("list", list);
		   map.put("lectureDivide", lectureDivide);
		   map.put("searchType", searchType);
		   map.put("search", search);
		   mav.addObject("map", map);
		   mav.addObject("pageMaker",pageMaker);
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
	    	 UserDTO user =(UserDTO) session.getAttribute("loginUser");
	    	//UserDTO writer = (UserDTO) session.getAttribute("loginUser");
	    	String writer = (String) user.getUserID();
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
