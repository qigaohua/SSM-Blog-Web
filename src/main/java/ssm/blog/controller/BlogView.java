/**
 * 
 */
package ssm.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import ssm.blog.entity.Blog;
import ssm.blog.entity.BlogTags;
import ssm.blog.service.BlogServiceImpl;
import ssm.blog.service.BlogTagsServiceImpl;

/**
 * @Desc   博客内容web显示相关功能类
 * @Author 齐高华
 *
 * @Date 2018年10月21日 下午4:22:30
 */

@Controller
public class BlogView {
	
	@Autowired
	BlogServiceImpl blogServiceImpl;
	
	@Autowired
	BlogTagsServiceImpl blogTagsServiceImpl;

	/**
	 * @Desc  博客内容获取，显示到web页面
	 * @param id 博客id
	 * @return
	 */
	@RequestMapping(value="/blogview")
	public ModelAndView name(Integer id) {
		Blog blog = blogServiceImpl.getBlog(id);
		List<BlogTags> blogTagsList = blogTagsServiceImpl.findBlogTagsMapping(id); 
			
		/* 获取上一篇博客id, title */
		Blog preBlog = blogServiceImpl.findPreBlog(id);
		if (preBlog == null) {
			preBlog = new Blog();
			preBlog.setId(0);
			preBlog.setTitle("这已经是第一篇博客了。。");
		}
		
		/* 获取下一篇博客id, title */
		Blog afterBlog = blogServiceImpl.findAfterBlog(id);
		if (afterBlog == null) {
			afterBlog = new Blog();
			afterBlog.setId(0);
			afterBlog.setTitle("这已经是最后一篇博客了。。");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Blog", blog);
		modelAndView.addObject("blogTagsList", blogTagsList);
		
		modelAndView.addObject("preBlog", preBlog);
		modelAndView.addObject("afterBlog", afterBlog);
		modelAndView.setViewName("info");
		
		/* 在这里增加博客浏览量 */
		blogServiceImpl.addBlogClickhit(id);
			
		return modelAndView;
	}
	
	
	/**
	 * @Desc  给博客点赞功能
	 * @param id  博客id
	 * @param value 点赞当前数量
	 * @param response
	 */
	@RequestMapping(value="/dianzan")
	public void dianzan(@RequestParam(value="id") Integer id, 
						@RequestParam(value="value") Integer value,
						HttpServletResponse response) {
		
		Integer ret = blogServiceImpl.modifyBlogLikes(id, value);
		
		JSONObject result = new JSONObject();		
		if (ret == null) {
			result.put("success", false);
		}
		else {
			result.put("success", true);
		}
		
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.println(result.toJSONString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}







