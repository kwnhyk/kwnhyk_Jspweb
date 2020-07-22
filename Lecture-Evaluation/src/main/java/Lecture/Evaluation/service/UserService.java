package Lecture.Evaluation.service;

import Lecture.Evaluation.user.UserDTO;

public interface UserService {

	
	int join(UserDTO userDTO) throws Exception;

	UserDTO getId(String userID)throws Exception;
	UserDTO getUser(String userID, String password) throws Exception;
	
	 String getEmail(String userID) throws Exception;
}
