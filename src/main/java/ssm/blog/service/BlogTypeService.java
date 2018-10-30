/**
 * 
 */
package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageCommon;

/**
 * @Desc   // 博客类别管理接口 
 * @Author 齐高华
 *
 * @Date 2018年10月16日 下午11:52:44
 */
public interface BlogTypeService {

	// 分页
	public PageCommon<BlogType> listByPage(PageCommon<BlogType> pageCommon);
	
	// 添加博客分类
	public Integer addBlogType(BlogType blogType);
	
	// 更新
	public Integer updateBlogType(BlogType blogType);
	
	// 删除
	public Integer deleteBlogType(Integer id);
	
	// 获取所有博客类型
	public List<BlogType> getBlogTypes();
}
