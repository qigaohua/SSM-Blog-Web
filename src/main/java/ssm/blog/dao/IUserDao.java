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
	public Integer insertUser(User user);
	public Integer deleteUser(Integer id);
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
}
