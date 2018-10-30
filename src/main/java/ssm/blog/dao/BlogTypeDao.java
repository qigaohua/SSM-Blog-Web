/**
 * 
 */
package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ssm.blog.entity.BlogType;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月14日 下午9:39:34
 */

@Component
public interface BlogTypeDao {
	public int addBlogType(BlogType blogType);
	public int delBlogType(int id);
	public int updateBlogType(BlogType blogType);
	public BlogType getBlogTypeById(int id);
	public List<BlogType> getBlogTypePage(@Param("start") Integer start, @Param("end") Integer end);
	
	// 获取博客类别的总数
	public Long getBlogTypeTotal();
	
	// 获取所有博客类别
	public List<BlogType> getBlogType();
}
