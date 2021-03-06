package Lecture.Evaluation.dao;

import java.util.Map;

import Lecture.Evaluation.domain.UserDTO;


public interface UserDao {
	
	 public  int join(UserDTO userDTO) throws Exception ;
	

	 public String findById(String userID) throws Exception;
	 public UserDTO UserfindById(String userID) throws Exception;
	 public UserDTO findByIdAndPassword(Map<String,Object> map) throws Exception;
	
	 
	 public String getUserEmail(String userID) throws Exception;
	 int alterKey(Map<String, Object> params); // 유저 인증키 생성 메서드
	  int alterUserKey(Map<String, Object> params); //유저 인증키 Y로 바꿔주는 메서드
}
