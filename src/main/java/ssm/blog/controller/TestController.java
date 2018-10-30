/**
 * 
 */
package ssm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月13日 下午10:26:45
 */

@Controller
public class TestController {
	
	@ResponseBody
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "hello SSM";
	}
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menu() {
		return "menu";
	}
}
