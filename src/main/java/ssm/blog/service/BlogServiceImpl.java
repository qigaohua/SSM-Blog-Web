/**
 * 
 */
package ssm.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.dao.BlogDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.PageCommon;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月18日 下午10:26:02
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	
	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#listBlogPage(ssm.blog.entity.PageCommon)
	 */
	public PageCommon<Blog> listBlogPage(String title, PageCommon<Blog> pageCommon) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("start", pageCommon.getStart());
		map.put("end", pageCommon.getEnd());
		
//		pageCommon.setResult(blogDao.getBlogPage(pageCommon.getStart(), pageCommon.getEnd()) );
		pageCommon.setResult(blogDao.getBlogPage(map));
		pageCommon.setTotal(blogDao.getBlogTotal());
		
		
		return pageCommon;
	}
	
	public PageCommon<Blog> listBlogPage(PageCommon<Blog> pageCommon) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", pageCommon.getStart());
		map.put("end", pageCommon.getEnd());
		
		pageCommon.setResult(blogDao.getBlogPage(map));
		return pageCommon;
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#deleteBlog(java.lang.Integer)
	 */
	public Integer deleteBlog(Integer id) {
		return blogDao.delBlogById(id);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#saveBlog(ssm.blog.entity.Blog)
	 */
	public Integer saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.insertBlog(blog);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#getBlog(java.lang.Integer)
	 */
	public Blog getBlog(Integer id) {
		return blogDao.getBlogById(id);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#modifyBlog(ssm.blog.entity.Blog)
	 */
	public Integer modifyBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#listBlogOfClickhit()
	 */
	public List<Blog> listBlogOfClickhit() {
		return blogDao.getBlogsByClickhit();
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#listBlogOfLikes()
	 */
	public List<Blog> listBlogOfLikes() {
		return blogDao.getBlogsByLikes();
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#listClassifyBlogs(java.lang.Integer)
	 */
	public PageCommon<Blog> listClassifyBlogs(PageCommon<Blog> pageCommon, Integer blogTypeId) {
/*		return blogDao.getClassifyBlogs(blogTypeId);*/
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("blogTypeId", blogTypeId);
		map.put("start", pageCommon.getStart());
		map.put("end", pageCommon.getEnd());
		
		pageCommon.setResult(blogDao.getClassifyBlogsOfPage(map));
		return pageCommon;
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#getBlogTotal()
	 */
	public Long getBlogTotal() {
		return blogDao.getBlogTotal();
	}

	public List<Blog> listAllBlogs() {
		return blogDao.getAllBlogs();
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#findPreBlog(java.lang.Integer)
	 */
	public Blog findPreBlog(Integer id) {
		return blogDao.getPreBlogById(id);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogService#findAfterBlog(java.lang.Integer)
	 */
	public Blog findAfterBlog(Integer id) {
		return blogDao.getAfterBlogById(id);
	}

	public Integer modifyBlogLikes(Integer id, Integer value) {
		return blogDao.updateBlogLikes(id, value);
	}

	public Integer addBlogClickhit(Integer id) {
		return blogDao.updateBlogclickHit(id);
	}

	public Integer getClassifyBlogTotal(Integer blogTypeId) {
		return blogDao.getClassifyBlogTotal(blogTypeId);
	}

	public PageCommon<Blog> listTagsBlogs(PageCommon<Blog> pageCommon, Integer tagsId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("tagsId", tagsId);
		map.put("start", pageCommon.getStart());
		map.put("end", pageCommon.getEnd());
		
		pageCommon.setResult(blogDao.getTagsBlogsOfPage(map));
		return pageCommon;
	}

	public Integer getTagsBlogTotal(Integer tagsId) {
		return blogDao.getTagsBlogTotal(tagsId);
	}

}
