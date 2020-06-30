package Lecture.Evaluation.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("yunhuk93@gmail.com","asdfg300");
		
	}
	
	
	
}
