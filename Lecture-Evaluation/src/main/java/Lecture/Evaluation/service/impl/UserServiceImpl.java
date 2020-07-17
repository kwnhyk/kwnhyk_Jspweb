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
	  public UserDTO getUser(String email, String password) throws Exception {
	    HashMap<String, Object> params = new HashMap<>();
	    params.put("email", email);
	    params.put("password", password);
	    return userDao.findByIdAndPassword(params);
	  }
	 @Override
	public boolean getUserEmailChecked(String userID) throws Exception {
		 return userDao.getUserEmailChecked(userID);
	 
	 }
	 @Override
	public String getUserEmail(String userID) throws Exception {
		 
		 return userDao.getUserEmail(userID);
	}
	 @Override
	public boolean setUserEmailChecked(String userID) throws Exception {
		 
		 return userDao.setUserEmailChecked(userID);
	}
}
