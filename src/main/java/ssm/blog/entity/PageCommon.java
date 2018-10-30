/**
 * 
 */
package ssm.blog.entity;

import java.util.List;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月15日 下午9:02:34
 */

public class PageCommon<T> {
	private int currPage;
	private int pageSize;
	private Long total;
	private Integer totalPage;
	private int start;
	private int end;
	private List<T> result;
	
	/**
	 * 
	 */
	PageCommon() {
		// TODO Auto-generated constructor stub
	}
	
	public PageCommon(int currPage, int pageSize) {
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.start = (currPage - 1) * pageSize;
//		this.end = currPage * pageSize;
		this.end = pageSize;
	}

	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the currPage
	 */
	public int getCurrPage() {
		return currPage;
	}

	/**
	 * @param currPage the currPage to set
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @return the result
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageCommon [currPage=" + currPage + ", pageSize=" + pageSize + ", total=" + total + ", start=" + start
				+ ", end=" + end + "]";
	}
}


