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
 * @Desc   //TODO ������� 
 * @Author ��߻�
 *
 * @Date 2018��10��21�� ����4:22:30
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
			preBlog.setTitle("���Ѿ��ǵ�һƪ�����ˡ���");
		}
		Blog afterBlog = blogServiceImpl.findAfterBlog(id);
		if (afterBlog == null) {
			afterBlog = new Blog();
			afterBlog.setId(0);
			afterBlog.setTitle("���Ѿ������һƪ�����ˡ���");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("Blog", blog);
		modelAndView.addObject("preBlog", preBlog);
		modelAndView.addObject("afterBlog", afterBlog);
		modelAndView.setViewName("info");
		
		return modelAndView;
	}
	
}







