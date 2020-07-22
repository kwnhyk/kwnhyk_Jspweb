package Lecture.Evaluation.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Lecture.Evaluation.service.MailSendService;
import Lecture.Evaluation.service.UserService;
import Lecture.Evaluation.user.UserDTO;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	MailSendService mailsender;
	
	
	
	@GetMapping("emailSend")
	public String emailSend() {
		return "/WEB-INF/jsp/user/emailSendAction.jsp";
	}
	@GetMapping("form")
	public String form() {
	
		return "/WEB-INF/jsp/user/form.jsp";
	
	}
	
	
	@PostMapping("signup")
	  public String signup(UserDTO user, Model model, HttpServletRequest request,
	      HttpServletResponse response) throws Exception {
	    if (userService.getId(user.getUserID()) != null) {
	      response.setStatus(400);
	    }
	    if (userService.join(user) > 0) {
	      // 인증 메일 보내기 메서드
	      mailsender.mailSendWithKey(user.getUserEmail(), user.getUserID(),user.getUserPassword() ,request);
	      response.setStatus(200);
	      return "redirect:/user/emailSend";
	    } else {
	      throw new Exception("회원을 추가할 수 없습니다.");
	    }
		
	  }
}
