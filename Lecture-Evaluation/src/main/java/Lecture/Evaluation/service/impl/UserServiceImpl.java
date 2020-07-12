package Lecture.Evaluation.service.impl;

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

}
