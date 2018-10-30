package ssm.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.dao.IPermissionDao;
import ssm.blog.entity.Permission;



@Service
public class PermissionService implements IPermissionService {

	@Autowired
	private  IPermissionDao permissionDao;
	
	public List<Permission> findPermissionByUsername(String username) {

		return permissionDao.getPermissionsByUserName(username);
	}

}
