/**
 * 
 */
package ssm.blog.controller;

import java.io.IOException;
//import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageCommon;
import ssm.blog.service.BlogTypeServiceImpl;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月15日 下午9:25:13
 */

@Controller
public class BlogTypeController {

	@Autowired(required=true)
	private BlogTypeServiceImpl blogTypeServiceImpl;
	
	@RequestMapping(value="/listPage")
	public String listPage(@RequestParam(value="page")String page, 
						   @RequestParam(value="rows")String rows, 
						   HttpServletResponse response) {
/*		System.out.println(Integer.parseInt(page));
		System.out.println(Integer.parseInt(rows));
*/		
		PageCommon<BlogType> pageCommon = new 
				PageCommon<BlogType>(Integer.parseInt(page), Integer.parseInt(rows));
		
		pageCommon = blogTypeServiceImpl.listByPage(pageCommon);
		
		JSONObject result = new JSONObject();
		String jsonString = JSON.toJSONString(pageCommon.getResult());
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		
		result.put("rows", jsonArray);
		result.put("total", pageCommon.getTotal());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter;
		try {
			printWriter = response.getWriter();
			printWriter.println(result.toJSONString());

			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="/saveBlogType")
	public String saveBlogType(BlogType blogType, HttpServletResponse response) {
		
		int ret = 0;
		
		System.out.println(blogType.toString());
		// id 为空值，表示插入; 否则表示更新
		if (blogType.getId() == null) {
			ret = blogTypeServiceImpl.addBlogType(blogType);
		}
		else {
			ret = blogTypeServiceImpl.updateBlogType(blogType);
		}
		
		JSONObject result = new JSONObject();
		if (ret > 0)
			result.put("success", true);
		else
			result.put("success", false);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter;
		try {
			printWriter = response.getWriter();
			printWriter.println(result.toJSONString());

			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="deleteBlogType")
	public String deleteBlogType(@RequestParam(value="idsStr") String idsStr, HttpServletResponse response) {
		String[] ids = idsStr.split(",");
		System.out.println(idsStr);
		
		JSONObject result = new JSONObject();
		
		for (int i = 0; i < ids.length; i ++) {
			// TODO 判断这个id的博客类型下是否有博客，没有就删除
			int id = Integer.parseInt(ids[0]);
			System.out.println(id);
			blogTypeServiceImpl.deleteBlogType(id);
		}
		result.put("success", true);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter;
		try {
			printWriter = response.getWriter();
			printWriter.println(result.toJSONString());

			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	@RequestMapping(value="/writeBlogOfGetAllBlogType")
	public ModelAndView writeBlog(Model model, HttpServletRequest request) {
		List<BlogType> blogTypeList = blogTypeServiceImpl.getBlogTypes();
	
		
/*		ServletContext servletContext = request.getSession().getServletContext();
		servletContext.setAttribute("blogTypeList", blogTypeList);
//		model.addAttribute("blogTypeList", list);
		for (BlogType bt: blogTypeList)
			System.out.println(bt.toString());
*/			
		
/*		for (BlogType bt: blogTypeList)
			System.out.println(bt.toString());
*/		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("blogTypeList", blogTypeList);
		modelAndView.setViewName("writeBlog");
		
		return modelAndView;
	}
}
