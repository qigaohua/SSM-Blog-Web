package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Role;


public interface IRoleService {
	public List<Role> findRolesByUserName(String username);
}
