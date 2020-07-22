package Lecture.Evaluation.service;

import javax.servlet.http.HttpServletRequest;

public interface MailSendService {
	  String getKey(boolean authkey, int size);

	  void mailSendWithKey(String email, String userId,String password, HttpServletRequest request);
	  int alterUserKey(String userID,String key);
}
