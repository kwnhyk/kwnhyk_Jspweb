package Lecture.Evaluation.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Lecture.Evaluation.service.UserService;
import Lecture.Evaluation.user.UserDTO;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	
	@Autowired
	private UserService userService;
	

	  @GetMapping("form")
	  public String form(HttpSession session ,Model model) {
	    UserDTO user = (UserDTO) session.getAttribute("userID");
	    if (user != null) {
	    	model.addAttribute("loginOn",1);
	      return "redirect:evaluation/form.jsp";
	    }else {
	    	
	    	model.addAttribute("loginOn",2);
	    	
	    	   return "/WEB-INF/jsp/auth/form.jsp";
	    	
	    }
	    
	    
	    	
	 
	    }

	
	@PostMapping("login")
	  public String login(HttpSession session, String id, String password, Model model)
	      throws Exception {
	    System.out.println("login()=============>" + id + password);
	    session.removeAttribute("userID");
	    UserDTO user = userService.getUser(id, password);
	    System.out.println("User============>" + user);
	    if (user != null) {
	    	if(user.isUserEmailChecked()) {
	    //  if (user.getAlterKey().equals("Y")) {
	        // 로그인 시 유저 정보가 세션에 "userID"로 저장됨.
	        session.setAttribute("userID", user);
	        return "redirect:../main2.jsp";
	      } else {
	        model.addAttribute("loginError", 1); // 이메일 인증을 안 한 경우
	        return "/WEB-INF/jsp/emailSendConfirm.jsp";
	      }
	    } else {
	      session.invalidate();
	      model.addAttribute("loginError", 2); // 아이디 유효하지 않은 경우
	      return "/WEB-INF/jsp/auth/form.jsp";
	    }
	  }
	

	
	
}
