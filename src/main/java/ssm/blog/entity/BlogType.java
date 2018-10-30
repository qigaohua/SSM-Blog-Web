/**
 * 
 */
package ssm.blog.entity;

import java.io.Serializable;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月14日 下午9:33:23
 */


public class BlogType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5710014448714067186L;
	
	private Integer id;
	private String typeName;
	private Integer orderNum;
	
	/**
	 * 
	 */
	public BlogType() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public BlogType(String typeName, Integer orderNum) {
		// TODO Auto-generated constructor stub
		this.typeName = typeName;
		this.orderNum = orderNum;
	}
	
	public BlogType (Integer id, String typeName,  Integer orderNum) {
		this.id = id;
		this.typeName = typeName;
		this.orderNum = orderNum;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the orderNum
	 */
	public int getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = String.format("blogtype{id=%d, typeName=%s, orderNum=%d}", 
										id, typeName, orderNum);
		return string;
	}
}
