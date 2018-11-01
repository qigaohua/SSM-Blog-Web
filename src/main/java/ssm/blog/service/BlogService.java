/**
 * 
 */
package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Blog;
import ssm.blog.entity.PageCommon;

/**
 * @Desc   //博客管理接口 
 * @Author 齐高华
 *
 * @Date 2018年10月16日 下午11:51:38
 */
public interface BlogService {
	public List<Blog> listAllBlogs();
	
	public PageCommon<Blog> listBlogPage(String title, PageCommon<Blog> pageCommon);
	public PageCommon<Blog> listBlogPage(PageCommon<Blog> pageCommon);
	public Integer deleteBlog(Integer id);
	public Integer saveBlog(Blog blog);
	public Long getBlogTotal();
	public Blog getBlog(Integer id);
	public Integer modifyBlog(Blog blog);
	

	/* 按页获取某个分类的博客 */
	public PageCommon<Blog> listClassifyBlogs(PageCommon<Blog> pageCommon, Integer blogTypeId);
	/* 获取某个分类的博客数量 */
	public Integer getClassifyBlogTotal(Integer blogTypeId);
	
	public List<Blog> listBlogOfClickhit();
	public List<Blog> listBlogOfLikes();
	
	/* 发现上一篇博客 */
	public Blog findPreBlog(Integer id);
	/* 发现下一篇博客 */
	public Blog findAfterBlog(Integer id);
	
	/* 更新点赞数 */
	public Integer modifyBlogLikes(Integer id, Integer value);
	
	/* 增加浏览量 +1 */
	public Integer addBlogClickhit(Integer id);
}
