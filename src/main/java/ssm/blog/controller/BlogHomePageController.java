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
 * @Desc   博客首页显示内容相关功能类 
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
	public ModelAndView listClassify(@RequestParam(value="page", defaultValue="1") String page,
									 @RequestParam(value="id") Integer blogTypeId) {
		
		ModelAndView modelAndView = new ModelAndView();
		PageCommon<Blog> pageCommon = new PageCommon<Blog>(Integer.parseInt(page), 5);
		
		/* 按页获取博客信息 */
		pageCommon = blogServiceImpl.listClassifyBlogs(pageCommon, blogTypeId);
		/* 获取某个类别博客总数 */
		pageCommon.setTotal((long)blogServiceImpl.getClassifyBlogTotal(blogTypeId));
		/* 得到总的页数，方便web页面分页  */
		Integer total = (int) ((pageCommon.getTotal() + pageCommon.getPageSize() - 1) / pageCommon.getPageSize());
		pageCommon.setTotalPage(total);
		
		modelAndView.addObject("classifyBlogPage", pageCommon);
		modelAndView.addObject("blogTypeId", blogTypeId);

		modelAndView.setViewName("classifyBlogs");
		
		return modelAndView;
	}
	
	/**
	 * @Desc  页面时间轴功能，获取所有博客，按时间倒叙显示
	 * @return
	 */
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
	
	
	/**
	 * @Desc  页面关于我功能， 显示个人信息
	 * @return
	 */
	@RequestMapping(value="about")
	public String aboutMe() {
		return "about";
	}
	
	
	/**
	 * @Desc 页面留言功能 TODO
	 * @return
	 */
	@RequestMapping(value="/leaveWord")
	public String leaveWordForMe() {
		return "leaveWord";
	}
	
}
