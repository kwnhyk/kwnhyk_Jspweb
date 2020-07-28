package Lecture.Evaluation.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Lecture.Evaluation.domain.UserDTO;
import Lecture.Evaluation.service.MailSendService;
import Lecture.Evaluation.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	MailSendService mailsender;
	
	
	

	@GetMapping("form")
	public String form() {
	
		return "user/form";
	
	}
	
	@PostMapping("signup")
	  public void signup(UserDTO user, Model model, HttpServletRequest request,
	      HttpServletResponse response) throws Exception {
	    if (userService.getId(user.getUserID()) != null) {
	      response.setStatus(400);
	    }
	    if (userService.join(user) > 0) {
	      // 인증 메일 보내기 메서드
	      mailsender.mailSendWithKey(user.getUserEmail(), user.getUserID(),user.getUserPassword() ,request);
	      response.setStatus(200);
	      
	    } else {
	      throw new Exception("회원을 추가할 수 없습니다.");
	    }
		
	  }
}
