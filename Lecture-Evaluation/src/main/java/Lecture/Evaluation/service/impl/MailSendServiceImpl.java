package Lecture.Evaluation.service.impl;

import Lecture.Evaluation.service.MailSendService;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	 JavaMailSender mailSender;
	@Autowired
	 SqlSessionTemplate sqlSession;
	 UserDAO userDao;
	
	// 이메일 난수 만드는 메서드
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}

	// 난수를 이용한 키 생성
	private boolean lowerCheck;
	private int size;

	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}

	// 회원가입 발송 이메일(인증키 발송)
	public void mailSendWithKey(String e_mail, String user_id, HttpServletRequest request) {
		
		String key = getKey(false, 20);
		userDao = sqlSession.getMapper(UserDaoInterface.class);
		userDao.GetKey(user_id, key); 
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>강의 평가를 위한 이메일 인증입니다!</h2><br><br>" 
				+ "<h3>" + user_id + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:8080" + request.getContextPath() + "/keyalter?user_id="+ user_id +"&user_key="+key+"'>인증하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject(String.format("[본인인증]%s 님의 인증메일입니다",user_id), "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(e_mail));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		

	
}
