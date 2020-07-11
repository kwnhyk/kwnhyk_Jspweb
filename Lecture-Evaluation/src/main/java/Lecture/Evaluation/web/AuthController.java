package Lecture.Evaluation.web;




	@Autowired
	private UserMailSendService mailsender;

  // 회원가입 컨트롤러
	@RequestMapping(value = "/userRegisterAction", method = RequestMethod.POST)
	public String userRegPass(UserDTO userDTO, Model model, HttpServletRequest request) {

		// 암호 확인
		System.out.println("첫번째:" + userVO.getUser_pw());
		// 비밀번호 암호화
		String encryPassword = UserSha256.encrypt(userVO.getUser_pw());
		userVO.setUser_pw(encryPassword);
		System.out.println("두번째:" + userVO.getUser_pw());
		// 회원가입 메서드
		reg_service.userReg_service(userVO);
		// 인증 메일 보내기 메서드
		mailsender.mailSendWithUserKey(userVO.getUser_email(), userVO.getUser_id(), request);

		return "redirect:/";
	}
