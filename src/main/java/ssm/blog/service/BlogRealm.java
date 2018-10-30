package ssm.blog.service;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.IntoOption;
import com.mysql.cj.xdevapi.DocResult;

import ssm.blog.entity.Permission;
import ssm.blog.entity.Role;
import ssm.blog.entity.User;




public class BlogRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	// 为该用户添加角色
	private void addRoles(String username, SimpleAuthorizationInfo info) {
		List<Role> roles = roleService.findRolesByUserName(username);
		
		/*System.out.println(roles.get(0).toString());*/
		
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				info.addRole(role.getName());
			}
		}
	}
	
	// 为该用户添加权限
	private void addPermission(String username, SimpleAuthorizationInfo info) {
		List<Permission> permissions = permissionService.findPermissionByUsername(username);
		
		if (permissions != null && permissions.size() > 0) {
			for (Permission permission : permissions) {
				info.addStringPermission(permission.getUrl());
			}
		}
	}
	
	
	/*
	    *    获取授权信息
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
		String username = (String) principals.fromRealm(getName()).iterator().next();
		
		if (!StringUtils.isEmpty(username)) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			
			addRoles(username, info);
			addPermission(username, info);
			
			return info;
		}
		
		return null;
	}

	
	/*
	    *     登录验证
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// 获取基于用户名和密码的令牌
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		
		String username = token.getUsername();
		
		System.out.println("doGetAuthenticationInfo: " + username);
		
		if (!StringUtils.isEmpty(username)) {
			User user = userService.fineUserByUserName(username);
			if (user != null) {
				/*System.out.println(user.getUsername() + " " + user.getPassword());*/
				return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			}
		}
		
		return null;
	}

}
