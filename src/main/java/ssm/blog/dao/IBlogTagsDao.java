package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.BlogTags;

public interface IBlogTagsDao {
	/* ��ȡ���еı�ǩ */
	public List<BlogTags> selectAllBlogTags();
	
	/* ��Ӳ�����Ϣ���������ǩ��ӳ��� */
	public Integer insertBlogTagsMapping(@Param("blogId") Integer blogId, @Param("tagsId") Integer tagsId);
	
	/* ���ݲ���id ɾ��������Ϣ���������ǩ��ӳ��*/
	public Integer deleteBlogTagsMapping(@Param("blogId") Integer blogId);
	
	/* ���ݲ���id ���Ҳ�����Ϣ���������ǩ��ӳ��*/
	public List<BlogTags> selectBlogTagsMapping(@Param("blogId") Integer blogId);
}
