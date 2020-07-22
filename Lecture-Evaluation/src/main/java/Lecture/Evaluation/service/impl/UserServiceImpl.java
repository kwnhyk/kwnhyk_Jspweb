package Lecture.Evaluation.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lecture.Evaluation.dao.UserDao;
import Lecture.Evaluation.service.UserService;
import Lecture.Evaluation.user.UserDTO;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public int join(UserDTO userDTO) throws Exception {
		
		return userDao.join(userDTO);
		
	}
	@Override
	public UserDTO getId(String userID) throws Exception {
		
		return userDao.findById(userID);
	}

	 @Override
	  public UserDTO getUser(String userID, String password) throws Exception {
	    HashMap<String, Object> params = new HashMap<>();
	    params.put("userID", userID);
	    params.put("userPassword", password);
	    return userDao.findByIdAndPassword(params);
	  }
	
	 @Override
	public String getEmail(String userID) throws Exception {
		 
		 return userDao.getUserEmail(userID);
	}
	
}
