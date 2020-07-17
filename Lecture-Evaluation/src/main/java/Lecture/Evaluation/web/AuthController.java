package Lecture.Evaluation.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	

	  @RequestMapping("form")
	  public String form(HttpSession session ,Model model) {
	    UserDTO user = (UserDTO) session.getAttribute("userID");
	    if (user != null) {
	    	model.addAttribute("loginOn",1);
	      return "redirect:../main2.jsp";
	    }
	    
	    	
	    return "/WEB-INF/jsp/auth/form.jsp";
	    }
	    
	    
	
	@RequestMapping("login")
	  public String login(HttpSession session, String id, String password, Model model)
	      throws Exception {
	    System.out.println("login()=============>" + id + password);
	    session.removeAttribute("loginUser");
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
	      model.addAttribute("loginError", 2); // 이메일이 유효하지 않은 경우
	      return "/WEB-INF/jsp/auth/form.jsp";
	    }
	  }
	@RequestMapping("signup")
	  public void signup(UserDTO user, Model model, HttpServletRequest request,
	      HttpServletResponse response) throws Exception {
	    if (userService.getId(user.getUserID()) != null) {
	      response.setStatus(400);
	    }
	    if (userService.join(user) > 0) {
	      // 인증 메일 보내기 메서드
	      mailsender.mailSendWithKey(user.getUserEmail(), user.getUserID(), request);
	      response.setStatus(200);
	    } else {
	      throw new Exception("회원을 추가할 수 없습니다.");
	    }
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