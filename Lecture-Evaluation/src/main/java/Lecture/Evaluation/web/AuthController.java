package Lecture.Evaluation.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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