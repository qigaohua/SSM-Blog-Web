package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.BlogTags;

public interface IBlogTagsDao {
	/* 获取所有的标签 */
	public List<BlogTags> selectAllBlogTags();
	
	/* 添加博客信息到博客与标签的映射表 */
	public Integer insertBlogTagsMapping(@Param("blogId") Integer blogId, @Param("tagsId") Integer tagsId);
	
	/* 根据博客id 删除博客信息到博客与标签的映射*/
	public Integer deleteBlogTagsMapping(@Param("blogId") Integer blogId);
	
	/* 根据博客id 查找博客信息到博客与标签的映射*/
	public List<BlogTags> selectBlogTagsMapping(@Param("blogId") Integer blogId);
}
