/**
 * 
 */
package ssm.blog.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import ssm.blog.entity.Blog;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageCommon;
import ssm.blog.service.BlogService;
import ssm.blog.service.BlogServiceImpl;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月18日 下午10:35:45
 */

@Controller
public class BlogController {
	
	@Autowired
	private BlogServiceImpl blogServiceImpl;
	
	
	@RequestMapping(value="/listBlogPage")
	public String listPage(@RequestParam(value="page") String page, 
						   @RequestParam(value="rows") String rows, 
						   Blog blog,
						   HttpServletResponse response) {
		
		PageCommon<Blog> pageCommon = new PageCommon<Blog>(Integer.parseInt(page), 
														Integer.parseInt(rows));
		
		pageCommon = blogServiceImpl.listBlogPage(blog.getTitle(), pageCommon);
		
		JSONObject result = new JSONObject();
		
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		
		String jsonString = JSON.toJSONString(pageCommon.getResult(),
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteDateUseDateFormat);
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
	
	@RequestMapping("/delBlog")
	public String deleteBlog(@RequestParam(value="idsStr") String idsStr, 
								HttpServletResponse response) {
		String[] ids = idsStr.split(",");
		
		for (int i = 0; i  < ids.length; i ++) {
			Integer id = Integer.parseInt(ids[i]);
			
			// TODO 需要删除博客下的评论
			blogServiceImpl.deleteBlog(id);
		}
		
		JSONObject result = new JSONObject();
		
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
	
	@RequestMapping(value="/saveBlog")
	public String saveBlog(Blog blog, HttpServletResponse response) {
		Integer ret = 0;
		
		System.out.println(blog.getId());
		if (blog.getId() != null) {
			// 更新
			ret = blogServiceImpl.modifyBlog(blog);
		}
		else {
			// 保存
			ret = blogServiceImpl.saveBlog(blog);
		}
		
		JSONObject result = new JSONObject();
		
		if (ret > 0) {
			// 成功
			result.put("success", true);
		}
		else {
			// 失败
			result.put("success", false);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println(result.toJSONString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@RequestMapping(value="/updateBlog")
	public ModelAndView updateBlog(Integer id, HttpServletRequest request) {
		
		Blog blog = blogServiceImpl.getBlog(id);
		
//		request.setAttribute("Blog", blog);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("Blog", blog);
		modelAndView.setViewName("writeBlog");
		
		return modelAndView;
	}
}
