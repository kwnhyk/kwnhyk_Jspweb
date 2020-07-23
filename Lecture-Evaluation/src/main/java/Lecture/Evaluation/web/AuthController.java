package Lecture.Evaluation.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Lecture.Evaluation.service.MailSendService;
import Lecture.Evaluation.service.UserService;
import Lecture.Evaluation.user.UserDTO;

@Controller
@RequestMapping("/auth")
public class AuthController{
	@Autowired
	private UserService userService;
	@Autowired
	private MailSendService mailsender;
	  @Autowired
	  ServletContext servletContext;

	  
		  @RequestMapping("form")
		  public String form(HttpSession session ,Model model) {
		    UserDTO user = (UserDTO) session.getAttribute("loginUser");
		    if (user != null) {
		    	model.addAttribute("loginOn",1);
		      return "redirect:evaluation/form";
		    }else {
		    	
		    	model.addAttribute("loginOn",2);
		    	
		    	   return "/WEB-INF/jsp/auth/form.jsp";
		    	
		    }
		    
		    
		    	
		 
		    }
	    
	   
	
	
	@RequestMapping("login")
	  public String login(HttpSession session, String userID, String password, Model model)
	      throws Exception {
	    System.out.println("login()=============>" + userID + password);
	    session.removeAttribute("loginUser");
	    UserDTO user = userService.getUser(userID, password);
	    System.out.println("User============>" + user);
	    if (user != null) {
	    	if(user.getUserEmailHash().equals("Y")) {
	    	//	user.isUserEmailChecked()
	    //  if (user.getAlterKey().equals("Y")) {
	        // 로그인 시 유저 정보가 세션에 "userID"로 저장됨.
	        session.setAttribute("loginUser", user);
	        return "redirect:../user/form";
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
	@GetMapping(value = "keyalter")
	  public String keyalterConfirm(@RequestParam("userID") String id, String password,
	      @RequestParam("userEmailHash") String key) throws Exception {

	    mailsender.alterUserKey(id, key); // mailsender의 경우 @Autowired
	    UserDTO user = userService.getId(id);
	    String userID = user.getUserID();
	    
	    return "redirect:login?userID=" + userID + "&password=" + password;
	  }
	@RequestMapping("logout")
		public String logout(HttpSession session) {
		session.invalidate();
			return "redirect:../../index.jsp";
		
	}

  // 회원가입 컨트롤러
/*	@RequestMapping(value = "/userRegisterAction", method = RequestMethod.POST)
	public String userRegPass(UserDTO userDTO, Model model, HttpServletRequest request) {

		// 암호 확인
		System.out.println("첫번째:" + userDTO.getUserPassword());
		// 비밀번호 암호화
		String encryPassword = SHA256.getSHA256(userDTO.getUserPassword());
		userDTO.setUserPassword(encryPassword);
		System.out.println("두번째:" + userDTO.getUserPassword());
		// 회원가입 메서드
		try {
			userService.join(userDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 인증 메일 보내기 메서드
		mailsender.mailSendWithKey(userDTO.getUserEmail(), userDTO.getUserID(), request);

		return "redirect:/";
	}
	*/
}