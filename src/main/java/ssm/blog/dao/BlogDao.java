/**
 * 
 */
package ssm.blog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import ssm.blog.entity.Blog;

/**
 * @Desc   //博客数据管理接口 
 * @Author 齐高华
 *
 * @Date 2018年10月18日 下午9:55:45
 */


@Component
public interface BlogDao {
	
	/* 获取所有博客（id, title, relerseDate） */
	public List<Blog> getAllBlogs();
	
/*	public List<Blog> getBlogPage(@Param("start") Integer start, @Param("end") Integer end);*/
	/* 分页获取博客 */
	public List<Blog> getBlogPage(Map<String, Object> map);
	/* 获取博客数量总数 */
	public Long getBlogTotal();
	public Integer delBlogById(@Param("id") Integer id);
	public Integer insertBlog(Blog blog);
	public Blog getBlogById(Integer id);
	public Integer updateBlog(Blog blog);
	
	/* 获取某一分类的所有博客, 按页获取 */
	public List<Blog> getClassifyBlogsOfPage(Map<String, Object> map);
	/* 获取某一分类的所有博客数量 */
	public Integer getClassifyBlogTotal(Integer blogTypeId);
	
	/* 获取某一标签的所有博客, 按页获取 */
	public List<Blog> getTagsBlogsOfPage(Map<String, Object> map);
	/* 获取某一标签的所有博客数量 */
	public Integer getTagsBlogTotal(Integer tagsId);
	
	
	/* 根据点击量获取博客  */
	public List<Blog> getBlogsByClickhit();
	/* 根据点赞数量(likes字段)获取博客  */
	public List<Blog> getBlogsByLikes();
	
	/* 根据获取id获取上一篇blog */
	public Blog getPreBlogById(Integer id);
	/* 根据获取id获取下一篇blog */
	public Blog getAfterBlogById(Integer id);
	
	/* 根据id更新blog点赞数量 */
	public Integer updateBlogLikes(@Param("id") Integer id, @Param("value") Integer value);
	
	/* 根据id更新blog点击量+1 */
	public Integer updateBlogclickHit(@Param("id") Integer id);
	
	/* 从标题、正文模糊搜索  */
	public List<Blog> selectBlogsByTitleAndContent(String searchValue);
}
