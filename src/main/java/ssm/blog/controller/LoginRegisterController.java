package ssm.blog.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;



@Controller
public class LoginRegisterController {
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request) {
		
		Subject subject = SecurityUtils.getSubject();
		
		/*System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));*/
		UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"), request.getParameter("password"));
				
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
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");
		
		System.out.println(username+" "+password+" "+repassword+" "+email);
		
		JSONObject result = new JSONObject();
		if (username != null && password != null && repassword != null && email != null) {
			result.put("success", true);
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
	
}






