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
 * @Desc   //�������ݹ���ӿ� 
 * @Author ��߻�
 *
 * @Date 2018��10��18�� ����9:55:45
 */


@Component
public interface BlogDao {
	
	/* ��ȡ���в��ͣ�id, title, relerseDate�� */
	public List<Blog> getAllBlogs();
	
/*	public List<Blog> getBlogPage(@Param("start") Integer start, @Param("end") Integer end);*/
	/* ��ҳ��ȡ���� */
	public List<Blog> getBlogPage(Map<String, Object> map);
	/* ��ȡ������������ */
	public Long getBlogTotal();
	public Integer delBlogById(@Param("id") Integer id);
	public Integer insertBlog(Blog blog);
	public Blog getBlogById(Integer id);
	public Integer updateBlog(Blog blog);
	
	/* ��ȡĳһ��������в���, ��ҳ��ȡ */
	public List<Blog> getClassifyBlogsOfPage(Map<String, Object> map);
	/* ��ȡĳһ��������в������� */
	public Integer getClassifyBlogTotal(Integer blogTypeId);
	
	/* ��ȡĳһ��ǩ�����в���, ��ҳ��ȡ */
	public List<Blog> getTagsBlogsOfPage(Map<String, Object> map);
	/* ��ȡĳһ��ǩ�����в������� */
	public Integer getTagsBlogTotal(Integer tagsId);
	
	
	/* ���ݵ������ȡ����  */
	public List<Blog> getBlogsByClickhit();
	/* ���ݵ�������(likes�ֶ�)��ȡ����  */
	public List<Blog> getBlogsByLikes();
	
	/* ���ݻ�ȡid��ȡ��һƪblog */
	public Blog getPreBlogById(Integer id);
	/* ���ݻ�ȡid��ȡ��һƪblog */
	public Blog getAfterBlogById(Integer id);
	
	/* ����id����blog�������� */
	public Integer updateBlogLikes(@Param("id") Integer id, @Param("value") Integer value);
	
	/* ����id����blog�����+1 */
	public Integer updateBlogclickHit(@Param("id") Integer id);
	
	/* �ӱ��⡢����ģ������  */
	public List<Blog> selectBlogsByTitleAndContent(String searchValue);
}
