/**
 * 
 */
package ssm.blog.dao;

import org.springframework.stereotype.Component;

import ssm.blog.entity.Bloger;

/**
 * @Desc   //TODO ������� 
 * @Author ��߻�
 *
 * @Date 2018��10��13�� ����7:17:06
 */

@Component
public interface BlogerDao {
	public Bloger getBlogerData(int id);
}
