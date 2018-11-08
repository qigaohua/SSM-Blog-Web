package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.BlogTags;
import ssm.blog.entity.PageCommon;

public interface IBlogTagsService {
	
	public Integer addBlogTags(BlogTags blogTags);
	
	/* 修改一个博客标签 */
	public Integer modifyBlogTags(BlogTags blogTags);
	
	public Integer removeBlogTags(Integer id);
	
	public List<BlogTags> getBlogAllTags();
	
	public Integer addBlogTagsMapping(Integer blogId, Integer tagsId);
	
	public Integer delBlogTagsMapping(Integer blogId);
	
	public List<BlogTags> findBlogTagsMapping(Integer blogId);
	
	public PageCommon<BlogTags> getTagsByPage(PageCommon<BlogTags> pageCommon);
	
	public Integer addBlogTagsNumber(Integer tagsId);
	
	public Integer subBlogTagsNumber(Integer blogId);
}
