package ssm.blog.service;

import ssm.blog.entity.User;

public interface IUserService {
	/* ���һ���û� */
	public Integer addUser(User user);
	
	/* �����û����������ҵ�User��Ϣ */
	public User fineUserByUserName(String username);
	public User fineUserByEmail(String email);
	
}
