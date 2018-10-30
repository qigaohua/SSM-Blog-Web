/**
 * 
 */
package ssm.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.entity.Blog;
import ssm.blog.service.BlogServiceImpl;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月21日 下午4:22:30
 */

@Controller
public class BlogView {
	
	@Autowired
	BlogServiceImpl blogServiceImpl;

	@RequestMapping(value="/blogview")
	public ModelAndView name(Integer id) {
		Blog blog = blogServiceImpl.getBlog(id);
		Blog preBlog = blogServiceImpl.findPreBlog(id);
		if (preBlog == null) {
			preBlog = new Blog();
			preBlog.setId(0);
			preBlog.setTitle("这已经是第一篇博客了。。");
		}
		Blog afterBlog = blogServiceImpl.findAfterBlog(id);
		if (afterBlog == null) {
			afterBlog = new Blog();
			afterBlog.setId(0);
			afterBlog.setTitle("这已经是最后一篇博客了。。");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("Blog", blog);
		modelAndView.addObject("preBlog", preBlog);
		modelAndView.addObject("afterBlog", afterBlog);
		modelAndView.setViewName("info");
		
		return modelAndView;
	}
	
}







