/**
 * 
 */
package ssm.blog.dao;

import org.springframework.stereotype.Component;

import ssm.blog.entity.User;

/**
 * @Desc   // 用户信息数据管理接口
 * @Author 齐高华
 *
 * @Date 2018年10月13日 下午7:17:06
 */

@Component
public interface IUserDao {
	public Integer insertUser(User user);
	public Integer deleteUser(Integer id);
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
}
