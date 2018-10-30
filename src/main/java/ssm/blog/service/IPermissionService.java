package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Permission;

public interface IPermissionService {
	public List<Permission> findPermissionByUsername(String username);
}
