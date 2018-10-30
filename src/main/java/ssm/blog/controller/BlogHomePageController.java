/**
 * 
 */
package ssm.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.alibaba.druid.stat.TableStat.Mode;
import com.mysql.cj.Session;

import ssm.blog.entity.Blog;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageCommon;
import ssm.blog.service.BlogServiceImpl;
import ssm.blog.service.BlogTypeServiceImpl;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月21日 下午2:05:35
 */


@Controller
public class BlogHomePageController {
	
	@Autowired
	private BlogServiceImpl blogServiceImpl;
	
	@Autowired
	private BlogTypeServiceImpl blogTypeServiceImpl;
	
	@RequestMapping(value="/index")
	public String homePage(@RequestParam(value="page", defaultValue="1") String page, HttpServletRequest request) {
		
		PageCommon<Blog> pageCommon = new PageCommon<Blog>(Integer.parseInt(page), 20);
		pageCommon = blogServiceImpl.listBlogPage(pageCommon);
		pageCommon.setTotal(blogServiceImpl.getBlogTotal());
		
		Integer total = (int) ((pageCommon.getTotal() + pageCommon.getPageSize() - 1) / pageCommon.getPageSize());
		pageCommon.setTotalPage(total);
		
		List<BlogType> blogTypeList = blogTypeServiceImpl.getBlogTypes();
		List<Blog> clickhitBlogList = blogServiceImpl.listBlogOfClickhit();
		List<Blog> likesBlogList = blogServiceImpl.listBlogOfLikes();
		
		HttpSession session = request.getSession();
//		session.setAttribute("BlogList", pageCommon.getResult());
		session.setAttribute("pageBlog", pageCommon);
		session.setAttribute("blogTypeList", blogTypeList);
		session.setAttribute("blogClickhitList", clickhitBlogList);
		session.setAttribute("blogLikesList", likesBlogList);
		
/*		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("BlogList", pageCommon.getResult());
		modelAndView.addObject("blogTypeList", blogTypeList);
		modelAndView.addObject("blogClickhitList", clickhitBlogList);
		modelAndView.addObject("blogLikesList", likesBlogList);
		modelAndView.setViewName("homepage");
		
		
		return modelAndView;
*/	
		return "homepage";
	}
	
	@RequestMapping(value="/pageBlog")
	public String pageBlog(@RequestParam(value="page", defaultValue="1") String page, HttpServletRequest request) {
		
		PageCommon<Blog> pageCommon = new PageCommon<Blog>(Integer.parseInt(page), 20);
		pageCommon = blogServiceImpl.listBlogPage(pageCommon);
		pageCommon.setTotal(blogServiceImpl.getBlogTotal());
		
		Integer total = (int) ((pageCommon.getTotal() + pageCommon.getPageSize() - 1) / pageCommon.getPageSize());
		pageCommon.setTotalPage(total);
		
		
		HttpSession session = request.getSession();
//		session.setAttribute("BlogList", pageCommon.getResult());
		session.setAttribute("pageBlog", pageCommon);
		
/*		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("BlogList", pageCommon.getResult());
		modelAndView.addObject("blogTypeList", blogTypeList);
		modelAndView.addObject("blogClickhitList", clickhitBlogList);
		modelAndView.addObject("blogLikesList", likesBlogList);
		modelAndView.setViewName("homepage");
		
		
		return modelAndView;
*/	
		return "homepage";
	}
	
	@RequestMapping(value="/listClassifyBlog")
	public ModelAndView listClassify(@RequestParam(value="id") Integer blogTypeId) {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Blog> classifyBlogs = blogServiceImpl.listClassifyBlogs(blogTypeId);
		modelAndView.addObject("classifyBlogs", classifyBlogs);
		modelAndView.setViewName("classifyBlogs");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="time")
	public ModelAndView timeBlogs() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Blog> timeBlogs = blogServiceImpl.listAllBlogs();
		
		for (Blog blog: timeBlogs)
			System.out.println(blog.toString());
		
		modelAndView.addObject("timeBlogs", timeBlogs);
		modelAndView.setViewName("time");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="about")
	public String aboutMe() {
		return "about";
	}
	
	
	@RequestMapping(value="/leaveWord")
	public String leaveWordForMe() {
		return "leaveWord";
	}
	
}
