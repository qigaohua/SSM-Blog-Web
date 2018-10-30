/**
 * 
 */
package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageCommon;

/**
 * @Desc   // ����������ӿ� 
 * @Author ��߻�
 *
 * @Date 2018��10��16�� ����11:52:44
 */
public interface BlogTypeService {

	// ��ҳ
	public PageCommon<BlogType> listByPage(PageCommon<BlogType> pageCommon);
	
	// ��Ӳ��ͷ���
	public Integer addBlogType(BlogType blogType);
	
	// ����
	public Integer updateBlogType(BlogType blogType);
	
	// ɾ��
	public Integer deleteBlogType(Integer id);
	
	// ��ȡ���в�������
	public List<BlogType> getBlogTypes();
}
