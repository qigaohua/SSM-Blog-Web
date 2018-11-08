package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.BlogTags;

public interface IBlogTagsDao {
	
	/* ���һ�����ͱ�ǩ */
	public Integer insertBlogTags(BlogTags blogTags);
	
	/* ����һ�����ͱ�ǩ */
	public Integer updateBlogTags(BlogTags blogTags);
	
	/* ɾ��һ�����ͱ�ǩ */
	public Integer deleteBlogTags(Integer id);
	
	/* ��ȡ���еı�ǩ */
	public List<BlogTags> selectAllBlogTags();
	
	/* ��Ӳ�����Ϣ���������ǩ��ӳ��� */
	public Integer insertBlogTagsMapping(@Param("blogId") Integer blogId, @Param("tagsId") Integer tagsId);
	
	/* ���ݲ���id ɾ��������Ϣ���������ǩ��ӳ��*/
	public Integer deleteBlogTagsMapping(@Param("blogId") Integer blogId);
	
	/* ���ݲ���id ���Ҳ�����Ϣ���������ǩ��ӳ��*/
	public List<BlogTags> selectBlogTagsMapping(@Param("blogId") Integer blogId);
	
	/* ��ҳ��ȡ���еı�ǩ */
	public List<BlogTags> getTagsByPage(@Param("start") Integer start, @Param("end") Integer end);
	
	/* ��ȡ��ǩ������ */
	public Long getTagsTotal();
	
	/* ���ݱ�ǩid ʹ ��ǩ����������һ */
	public Integer addTagsNumber(Integer tagsId);
	
	/* ���ݲ���id ʹ���Ͷ�Ӧ�����б�ǩ����ȥ1 */
	public Integer subTagsNumber(Integer blogId);
}
