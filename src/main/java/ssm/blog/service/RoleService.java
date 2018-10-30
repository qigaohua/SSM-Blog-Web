package ssm.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.entity.Role;
import ssm.blog.dao.IRoleDao;


@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleDao roleDao; 
	
	public List<Role> findRolesByUserName(String username) {

		return roleDao.getRolesByUserName(username);
	}

}
