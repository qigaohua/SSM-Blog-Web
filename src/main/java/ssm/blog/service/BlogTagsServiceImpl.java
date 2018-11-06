package ssm.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.dao.IBlogTagsDao;
import ssm.blog.entity.BlogTags;

@Service
public class BlogTagsServiceImpl implements IBlogTagsService {

	@Autowired
	private IBlogTagsDao blogTagsDao;
	
	public List<BlogTags> getBlogAllTags() {
		return blogTagsDao.selectAllBlogTags();
	}

	public Integer addBlogTagsMapping(Integer blogId, Integer tagsId) {
		return blogTagsDao.insertBlogTagsMapping(blogId, tagsId);
	}

	public Integer delBlogTagsMapping(Integer blogId) {
		return blogTagsDao.deleteBlogTagsMapping(blogId);
	}

	public List<BlogTags> findBlogTagsMapping(Integer blogId) {
		return blogTagsDao.selectBlogTagsMapping(blogId);
	}

}
