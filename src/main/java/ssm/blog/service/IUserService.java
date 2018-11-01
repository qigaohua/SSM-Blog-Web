package ssm.blog.service;

import ssm.blog.entity.User;

public interface IUserService {
	/* 添加一个用户 */
	public Integer addUser(User user);
	
	/* 根据用户名、邮箱找到User信息 */
	public User fineUserByUserName(String username);
	public User fineUserByEmail(String email);
	
}
