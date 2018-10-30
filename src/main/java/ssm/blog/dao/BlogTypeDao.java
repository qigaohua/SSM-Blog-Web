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
 * @Desc   //TODO ������� 
 * @Author ��߻�
 *
 * @Date 2018��10��14�� ����9:39:34
 */

@Component
public interface BlogTypeDao {
	public int addBlogType(BlogType blogType);
	public int delBlogType(int id);
	public int updateBlogType(BlogType blogType);
	public BlogType getBlogTypeById(int id);
	public List<BlogType> getBlogTypePage(@Param("start") Integer start, @Param("end") Integer end);
	
	// ��ȡ������������
	public Long getBlogTypeTotal();
	
	// ��ȡ���в������
	public List<BlogType> getBlogType();
}
