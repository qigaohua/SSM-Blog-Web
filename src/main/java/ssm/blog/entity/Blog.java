/**
 * 
 */
package ssm.blog.entity;

import java.util.Date;

/**
 * @Desc   //�������� 
 * @Author ��߻�
 *
 * @Date 2018��10��18�� ����9:45:57
 */
public class Blog {
	// ���ͱ��
	private Integer id;
	// ���ͱ���
	private String title;
	// ����ժҪ
	private String summary;
	// ������������
	private String content;
	
	// ��������
	private Date releaseDate;
	// ��������
	private Date updateDate;
	
	// ���ͱ�ǩ
	private String tags;
	
	// ���͹ؼ���
	private String keyWord;
	// ������
	private Integer clickHit;
	
	// ������
	private Integer likes;
	
	// ��������
	private BlogType blogType;
	
	// ��������
	private String author;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the keyWord
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * @param keyWord the keyWord to set
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * @return the clickHit
	 */
	public Integer getClickHit() {
		return clickHit;
	}

	/**
	 * @param clickHit the clickHit to set
	 */
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}

	/**
	 * @return the blogType
	 */
	public BlogType getBlogType() {
		return blogType;
	}

	/**
	 * @param blogType the blogType to set
	 */
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

	/**
	 * @return the likes
	 */
	public Integer getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(Integer likes) {
		this.likes = likes;
	}


	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content
				+ ", releaseDate=" + releaseDate + ", updateDate=" + updateDate + ", tags=" + tags + ", keyWord="
				+ keyWord + ", clickHit=" + clickHit + ", likes=" + likes + ", blogType=" + blogType + ", author="
				+ author + "]";
	}
		
}
