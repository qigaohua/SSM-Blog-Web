/**
 * 
 */
package ssm.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssm.blog.dao.BlogTypeDao;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageCommon;

/**
 * @Desc   // 博客类别管理类 
 * @Author 齐高华
 *
 * @Date 2018年10月15日 下午9:14:16
 */

@Component
public class BlogTypeServiceImpl implements BlogTypeService {

	@Autowired
	private BlogTypeDao blogTypeDao;
	
	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogTypeService#listByPage(ssm.blog.entity.PageCommon)
	 */
	public PageCommon<BlogType> listByPage(PageCommon<BlogType> pageCommon) {
		// TODO Auto-generated method stub
		
		pageCommon.setResult(blogTypeDao.getBlogTypePage(pageCommon.getStart(), pageCommon.getEnd()));
		pageCommon.setTotal(blogTypeDao.getBlogTypeTotal());
		
/*		List<BlogType> btList = pageCommon.getResult();
		for (BlogType bt : btList)
			System.out.println(bt.toString());
		
		System.out.println("total = " + pageCommon.getTotal());
*/		
		return pageCommon;
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogTypeService#addBlogType(ssm.blog.entity.BlogType)
	 */
	public Integer addBlogType(BlogType blogType) {
		// TODO Auto-generated method stub
		return blogTypeDao.addBlogType(blogType);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogTypeService#updateBlogType(ssm.blog.entity.BlogType)
	 */
	public Integer updateBlogType(BlogType blogType) {
		// TODO Auto-generated method stub
		return blogTypeDao.updateBlogType(blogType);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogTypeService#deleteBlogType(ssm.blog.entity.BlogType)
	 */
	public Integer deleteBlogType(Integer id) {
		// TODO Auto-generated method stub
		return blogTypeDao.delBlogType(id);
	}

	/* (non-Javadoc)
	 * @see ssm.blog.service.BlogTypeService#getBlogTypes()
	 */
	public List<BlogType> getBlogTypes() {
		// TODO Auto-generated method stub
		return blogTypeDao.getBlogType();
	}


}
