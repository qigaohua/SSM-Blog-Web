package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Permission;

public interface IPermissionDao {
	
	/*
	 * SELECT * FROM permission AS P 
	 *	JOIN role_permission AS RP ON P.id=RP.permission_id
	 *	JOIN role AS R ON R.id = RP.role_id
	 *	JOIN user_role AS UR ON UR.role_id = RP.role_id 
	 *	JOIN user as U ON U.id = UR.user_id
	 *	WHERE U.username="FlyQi"
	 *  	根据用户名得到该用户的所有权限
	 */
	public List<Permission> getPermissionsByUserName(String username); 
}
