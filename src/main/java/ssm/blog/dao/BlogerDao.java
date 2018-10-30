/**
 * 
 */
package ssm.blog.dao;

import org.springframework.stereotype.Component;

import ssm.blog.entity.Bloger;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月13日 下午7:17:06
 */

@Component
public interface BlogerDao {
	public Bloger getBlogerData(int id);
}
