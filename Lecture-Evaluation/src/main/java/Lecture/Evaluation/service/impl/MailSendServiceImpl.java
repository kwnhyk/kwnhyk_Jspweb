package Lecture.Evaluation.service.impl;

import Lecture.Evaluation.dao.UserDao;
import Lecture.Evaluation.service.MailSendService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	 JavaMailSender mailSender;
	@Autowired
	 SqlSessionTemplate sqlSession;
	 UserDao userDao;
	
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
	@Override
	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}
	@Override
	public int alterUserKey(String userId, String key) {
		int resultCnt =0;
		userDao = sqlSession.getMapper(UserDao.class);
		Map<String,Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("key", key);
		resultCnt = userDao.alterUserKey(params);
		
		return resultCnt;
		
	}
	
	// 회원가입 발송 이메일(인증키 발송)
	@Override
	public void mailSendWithKey(String email, String userId, HttpServletRequest request) {
		
		String key = getKey(false, 20);
		userDao = sqlSession.getMapper(UserDao.class);
		Map<String,Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("key", key);
		
		if(userDao.alterKey(params)>0){
		
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>강의 평가를 위한 이메일 인증입니다!</h2><br><br>" 
				+ "<h3>" + userId + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:8080" + request.getContextPath() + "/keyalter?user_id="+ userId +"&user_key="+key+"'>인증하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject(String.format("[본인인증]%s 님의 인증메일입니다",userId), "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		}
	
	
}
}
