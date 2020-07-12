package Lecture.Evaluation.dao;

import java.util.Map;

import Lecture.Evaluation.user.UserDTO;

public interface UserDao {
	
	 public  int join(UserDTO userDTO) throws Exception ;
		
		
	 public UserDTO findById(String userID) throws Exception;
	 public boolean getUserEmailChecked(String userID) throws Exception;
	 int alterKey(Map<String, Object> params); // 유저 인증키 생성 메서드
	  
	  int alterUserKey(Map<String, Object> params); //유저 인증키 Y로 바꿔주는 메서드
}
