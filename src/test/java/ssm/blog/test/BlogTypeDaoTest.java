/**
 * 
 */
package ssm.blog.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.BlogTypeDao;
import ssm.blog.dao.BlogerDao;
import ssm.blog.dao.IUserDao;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.User;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月14日 下午10:04:21
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class BlogTypeDaoTest {

	@Autowired
	private BlogTypeDao blogTypeDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Test
	public void testAddBlogType() {
		BlogType blogType = new BlogType(1, "java", 1);
		
		blogTypeDao.addBlogType(blogType);
		System.out.println("ok ...");
	}
	
	@Test
	public void testGetBlogTypeById() {
		BlogType blogType = blogTypeDao.getBlogTypeById(1);
		
		System.out.println(blogType.toString());
	}
	
	@Test
	public void testGetBlogTypePage( ) {
		Integer page = 2;
		Integer pagesize = 2;
		Integer start = (page -1) * pagesize;
		Integer end = page * pagesize;
		
		List<BlogType> blogTypeList = blogTypeDao.getBlogTypePage(start, end);
		for (BlogType bType : blogTypeList) 
			System.out.println(bType.toString());
	}

	@Test
	public void testGetBlogTypeTotal() {
		Long res = blogTypeDao.getBlogTypeTotal();
		
		System.out.println("Total = " + res);
	}
	
	@Test
	public void testDelBlogTypeTotal() {
		int id = 10;
		
		blogTypeDao.delBlogType(10);
		
	}
	
	
	@Test
	public void testGetUserByData() {
		User user = userDao.getUserData("FlyQi");
		System.out.println(user.toString());
	}
}



