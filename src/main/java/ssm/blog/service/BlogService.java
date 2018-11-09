/**
 * 
 */
package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Blog;
import ssm.blog.entity.PageCommon;

/**
 * @Desc   //���͹���ӿ� 
 * @Author ��߻�
 *
 * @Date 2018��10��16�� ����11:51:38
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
	

	/* ��ҳ��ȡĳ������Ĳ��� */
	public PageCommon<Blog> listClassifyBlogs(PageCommon<Blog> pageCommon, Integer blogTypeId);
	/* ��ȡĳ������Ĳ������� */
	public Integer getClassifyBlogTotal(Integer blogTypeId);
	
	/* ��ҳ��ȡĳ����ǩ�Ĳ��� */
	public PageCommon<Blog> listTagsBlogs(PageCommon<Blog> pageCommon, Integer tagsId);
	/* ��ȡĳ����ǩ�Ĳ������� */
	public Integer getTagsBlogTotal(Integer tagsId);
	
	public List<Blog> listBlogOfClickhit();
	public List<Blog> listBlogOfLikes();
	
	/* ������һƪ���� */
	public Blog findPreBlog(Integer id);
	/* ������һƪ���� */
	public Blog findAfterBlog(Integer id);
	
	/* ���µ����� */
	public Integer modifyBlogLikes(Integer id, Integer value);
	
	/* ��������� +1 */
	public Integer addBlogClickhit(Integer id);
	
	/* �ӱ��⡢����ģ������  */
	public List<Blog> searchBlogs(String searchValue);
}
