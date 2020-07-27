package Lecture.Evaluation.service;

import Lecture.Evaluation.domain.UserDTO;

public interface UserService {

	
	int join(UserDTO userDTO) throws Exception;

	String getId(String userID)throws Exception;
	UserDTO getUser(String userID, String password) throws Exception;
	UserDTO get(String userID)throws Exception;
	 String getEmail(String userID) throws Exception;
}
