/**
 * 
 */
package ssm.blog.dao;

import org.springframework.stereotype.Component;

import ssm.blog.entity.User;

/**
 * @Desc   // �û���Ϣ���ݹ���ӿ�
 * @Author ��߻�
 *
 * @Date 2018��10��13�� ����7:17:06
 */

@Component
public interface IUserDao {
	public Integer saveUser(User user);
	public Integer deleteUser(Integer id);
	public User getUserDataById(int id);
	public User getUserData(String username);
}
