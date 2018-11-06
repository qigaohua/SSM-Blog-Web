package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.BlogTags;

public interface IBlogTagsService {
	public List<BlogTags> getBlogAllTags();
	
	public Integer addBlogTagsMapping(Integer blogId, Integer tagsId);
	
	public Integer delBlogTagsMapping(Integer blogId);
	
	public List<BlogTags> findBlogTagsMapping(Integer blogId);
}
