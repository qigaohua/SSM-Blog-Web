package ssm.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.dao.IBlogTagsDao;
import ssm.blog.entity.BlogTags;
import ssm.blog.entity.PageCommon;

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

	public PageCommon<BlogTags> getTagsByPage(PageCommon<BlogTags> pageCommon) {
		
		pageCommon.setResult(blogTagsDao.getTagsByPage(pageCommon.getStart(), pageCommon.getEnd()));
		pageCommon.setTotal(blogTagsDao.getTagsTotal());
		
		return pageCommon;
	}

	public Integer addBlogTags(BlogTags blogTags) {
		return blogTagsDao.insertBlogTags(blogTags);
	}

	public Integer modifyBlogTags(BlogTags blogTags) {
		return blogTagsDao.updateBlogTags(blogTags);
	}

	public Integer removeBlogTags(Integer id) {
		return blogTagsDao.deleteBlogTags(id);
	}

	public Integer addBlogTagsNumber(Integer tagsId) {
		return blogTagsDao.addTagsNumber(tagsId);
	}

	public Integer subBlogTagsNumber(Integer blogId) {
		return blogTagsDao.subTagsNumber(blogId);
	}

}
