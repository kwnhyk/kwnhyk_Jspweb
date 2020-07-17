package Lecture.Evaluation.service;

import Lecture.Evaluation.user.UserDTO;

public interface UserService {

	
	int join(UserDTO userDTO) throws Exception;

	UserDTO getId(String userID)throws Exception;
	UserDTO getUser(String userID, String password) throws Exception;
	boolean getUserEmailChecked(String userID) throws Exception;
	 boolean setUserEmailChecked(String userID)throws Exception;
	 String getUserEmail(String userID) throws Exception;
}
