package Lecture.Evaluation.web;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import Lecture.Evaluation.domain.EvaluationDTO;
import Lecture.Evaluation.domain.UserDTO;
import Lecture.Evaluation.service.EvaluationService;
import Lecture.Evaluation.service.MailSendService;
import Lecture.Evaluation.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController{
	static Logger logger = LogManager.getLogger(AuthController.class);
	@Autowired
	 UserService userService;
	@Autowired
	private MailSendService mailsender;
	  @Autowired
	  ServletContext servletContext;
	  @Autowired
	  EvaluationService evaluationService;
	 
	  
	  @GetMapping("form")
	  public String form(HttpSession session) {
		 UserDTO user =(UserDTO) session.getAttribute("loginUser");
		 if(user !=null) {
		    
		    return "redirect:../evaluation/list";
		  }
		 return "/WEB-INF/jsp/auth/form.jsp";
	  }
	

	@PostMapping("login")
	  public ModelAndView login(HttpSession session, HttpServletResponse response,String userID, String userPassword, String saveEmail,  Model model)
	      throws Exception {
	    System.out.println("login()=============>" + userID + userPassword);
	   session.removeAttribute("loginUser");
	    Cookie cookie = new Cookie("userID", userID);
	    if (saveEmail != null) {
	      cookie.setMaxAge(60 * 60 * 24 * 30);
	    } else {
	      cookie.setMaxAge(0);
	    }
	    response.addCookie(cookie);
	    UserDTO user = userService.getUser(userID, userPassword);
	    System.out.println("User============>" + user);
	    if (user != null) {
	    	if(user.getUserEmailHash().equals("Y")) {
	    		
	    	//	user.isUserEmailChecked()
	    //  if (user.getAlterKey().equals("Y")) {
	        // 로그인 시 유저 정보가 세션에 "userID"로 저장됨.
	    		
	        session.setAttribute("loginUser", user);
	        
	        System.out.println("good Y");
	        String url = "redirect:../evaluation/list";
	        return new ModelAndView(url);
	        
	       
	      } else {
	    	  System.out.println("not Y");
	        model.addAttribute("loginError", 1); // 이메일 인증을 안 한 경우
	        String url = "/WEB-INF/jsp/auth/form.jsp";
	        return new ModelAndView(url);
	       
	      }
	    } else {
	      session.invalidate();
	      model.addAttribute("loginError", 2); // 아이디 유효하지 않은 경우
	      String url = "/WEB-INF/jsp/auth/form.jsp";
	        return new ModelAndView(url);
	       
	    }
	  }
	@PostMapping(value = "keyalter")
	  public String keyalterConfirm(@RequestParam("userID") String id, String password,
	      @RequestParam("userEmailHash") String key) throws Exception {

	    mailsender.alterUserKey(id, key); // mailsender의 경우 @Autowired
	    UserDTO user = userService.getId(id);
	   // String userID = user.getUserID();
	    
	    return "/WEB-INF/jsp/user/emailSendAction.jsp";
	  }
	@RequestMapping("logout")
		public String logout(HttpSession session) {
		session.invalidate();
			return "redirect:../../index.jsp";
		
	}
	 @SuppressWarnings("unchecked")
	  @GetMapping("facebookLogin")
	  public String facebookLogin( //
	      String accessToken, //
	      HttpSession session, //
	      Model model) throws Exception {

	    // 액세스토큰을 가지고 페이스북 서버에 사용자 정보를 요청한다.
	    // 1) Facebook Graph API 실행하기
	    // => JSON 또는 XML을 리턴하는 HTTP 요청을 코딩하는 방법?
	    //    - 스프링에서 제공하는 RestTemplate 클래스를 사용하라.
	    //    - JSON 또는 XML을 자바 객체로 자동 변환해주기 때문에 편리하다.
	    RestTemplate restTemplate = new RestTemplate();

	    // 2) 서버에 요청하기
	    // => 첫 번째 파라미터 : 요청 URL
	    // => 두 번째 파라미터 : 서버가 응답한 JSON을 어떤 타입의 객체로 만들지 지정.

	    Map<String,Object> response = restTemplate.getForObject(
	        "https://graph.facebook.com/v7.0/me?access_token={1}&fields={2}",
	        Map.class,
	        accessToken,
	        "id,name,email");

	    // 사용자 정보 확인
	    String email = (String) response.get("email");
	    logger.info("페이스북 로그인 사용자 이메일: {}", email);

	    if (email == null) {
	      logger.info("페이스북 액세스토큰이 무효하다.");

	      // 액세스토큰이 무효하다면, 다시 로그인 입력 폼으로 보낸다.
	      session.invalidate();
	     // model.addAttribute("refreshUrl", "2;url=form");
	      return "/app/auth/form";
	    }

	    UserDTO user = userService.getId(email);
	    if (user == null) {
	      // 현재 서버에 등록되지 않았다면, 새 사용자로 자동 등록한다.
	    	user = new UserDTO();
	    	user.setUserID(email);
	    	user.setUserEmail(email);
	    	user.setUserEmailHash("Y");
	    	user.setUserPassword(UUID.randomUUID().toString());
	    	userService.join(user);
	      logger.info("페이지북 사용자를 회원으로 등록한다.");
	    }

	    logger.info("세션에 로그인 사용자 정보를 보관한다.");
	    session.setAttribute("loginUser", user);
	  //  model.addAttribute("refreshUrl", "2;url=../../index.html");

	    return "/app/auth/form";
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