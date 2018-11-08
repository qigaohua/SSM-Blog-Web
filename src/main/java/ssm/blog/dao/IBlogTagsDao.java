package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.BlogTags;

public interface IBlogTagsDao {
	
	/* 添加一个博客标签 */
	public Integer insertBlogTags(BlogTags blogTags);
	
	/* 更新一个博客标签 */
	public Integer updateBlogTags(BlogTags blogTags);
	
	/* 删除一个博客标签 */
	public Integer deleteBlogTags(Integer id);
	
	/* 获取所有的标签 */
	public List<BlogTags> selectAllBlogTags();
	
	/* 添加博客信息到博客与标签的映射表 */
	public Integer insertBlogTagsMapping(@Param("blogId") Integer blogId, @Param("tagsId") Integer tagsId);
	
	/* 根据博客id 删除博客信息到博客与标签的映射*/
	public Integer deleteBlogTagsMapping(@Param("blogId") Integer blogId);
	
	/* 根据博客id 查找博客信息到博客与标签的映射*/
	public List<BlogTags> selectBlogTagsMapping(@Param("blogId") Integer blogId);
	
	/* 分页获取所有的标签 */
	public List<BlogTags> getTagsByPage(@Param("start") Integer start, @Param("end") Integer end);
	
	/* 获取标签总数量 */
	public Long getTagsTotal();
	
	/* 根据标签id 使 标签引用数量加一 */
	public Integer addTagsNumber(Integer tagsId);
	
	/* 根据博客id 使博客对应的所有标签都减去1 */
	public Integer subTagsNumber(Integer blogId);
}
