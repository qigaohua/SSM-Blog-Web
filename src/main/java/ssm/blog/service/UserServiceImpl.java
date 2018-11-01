package ssm.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.dao.IUserDao;
import ssm.blog.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public User fineUserByUserName(String username) {
		return  userDao.getUserByUsername(username);
	}


	public User fineUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	public Integer addUser(User user) {
		return userDao.insertUser(user);
	}

}
