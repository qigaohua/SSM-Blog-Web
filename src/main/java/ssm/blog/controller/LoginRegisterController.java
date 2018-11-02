package ssm.blog.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import ssm.blog.entity.User;
import ssm.blog.service.IUserService;
import ssm.blog.service.UserServiceImpl;



@Controller
public class LoginRegisterController {
	
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request) {
		
		Subject subject = SecurityUtils.getSubject();
		
		String username = request.getParameter("username");
		User user = userServiceImpl.fineUserByUserName(username);
		
		String md5Password = MD5Password(request.getParameter("password"), user.getSalt());
		UsernamePasswordToken token = new UsernamePasswordToken(username, md5Password);
				
		try {
			subject.login(token);
			return "redirect:index";
		} catch (AuthenticationException e) {
			/*System.err.println("用户名密码错误");*/
			request.setAttribute("errorMsg", "你输入的用户名密码错误，请重新输入");
		}
		
		return "toLogin";
	}
	
	
	@RequestMapping(value="toLogin")
	public String toLogin() {
		return "toLogin";
	}
	
	/**
	 * @Desc  用户注册功能
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");
		
		/*System.out.println(username+" "+password+" "+repassword+" "+email);*/
		
		JSONObject result = new JSONObject();
		if (username != null && password != null && repassword != null && email != null) {
			
			if (userServiceImpl.fineUserByUserName(username) != null) {
				result.put("sueecss", false);
				result.put("errMsg", "用户名已经存在");
			} 
			else if (userServiceImpl.fineUserByEmail(email) != null) {
				result.put("sueecss", false);
				result.put("errMsg", "该邮箱已经注册");	
			}
			else {
				String salt = produceSalt(32);
				/*System.out.println(">>>>>>salt: " + salt);*/
				
				String md5Password = MD5Password(password, salt);	
				/*System.out.println(">>>>>>md5Password: " + md5Password);*/
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(md5Password);
				user.setEmail(email);
				user.setSalt(salt);
				
				Integer ret = userServiceImpl.addUser(user);
				if (ret > 0)
					result.put("success", true);
				else {
					result.put("sueecss", false);
					result.put("errMsg", "用户添加失败");
				}
			}		

		}
		else {
			result.put("sueecss", false);
			result.put("errMsg", "信息不能为空");
		}
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter printWriter = response.getWriter();

			printWriter.println(result.toJSONString());
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * @Desc  生成一个指定长度的随机字符串，用作加密密码的盐
	 * @param length 
	 * @return
	 */
	public static String produceSalt(int length) {
		Random random = new Random();
		StringBuilder string = new StringBuilder(length);
		int x = 0;
		
		for (int i = 0; i < length; i ++) {
			x = random.nextInt(10000) % 3;
			switch (x) {
			case 0:			
				string.append((char)('A' + random.nextInt(10000) % 26));	
				break;
			case 1:
				string.append((char)('a' + random.nextInt(10000) % 26));
				break;
			case 2:
				string.append((char)('0' + random.nextInt(10000) % 10));
				break;
			default:
				string.append('x');
				break;
			}
		}
		
		return string.toString();
	}

	public String MD5Password(String password, String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest((password + salt).getBytes());
			
			/**
			 *    可行方案2
			String md5Str = new BigInteger(1, bytes).toString(16);
			for (int i = 0; i < 32 - md5Str.length(); i ++)
				md5Str = "0" + md5Str;
			return md5Str;
			*/
			
			return toHex(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String toHex(byte[] bytes) {
		final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
		
		StringBuilder string = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			string.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			string.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		
		return string.toString();
	}
}






