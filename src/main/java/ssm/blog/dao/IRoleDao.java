package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Role;


public interface IRoleDao {
	/*
	 *  SELECT * FROM role AS R 
	 *	JOIN user_role AS UR ON R.id=UR.role_id 
	 *	JOIN user as U ON U.id = UR.user_id
	 *	WHERE U.username="FlyQi"
	 */
	public List<Role> getRolesByUserName(String username);
}
