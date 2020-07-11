package Lecture.Evaluation.service;

import javax.servlet.http.HttpServletRequest;

public interface MailSendService {
	  String getKey(boolean authkey, int size);

	  void mailSendWithKey(String email, String password, HttpServletRequest request);
}
