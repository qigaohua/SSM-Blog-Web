/**
 * 
 */
package ssm.blog.entity;

import java.io.Serializable;

/**
 * @Desc   //TODO 添加描述 
 * @Author 齐高华
 *
 * @Date 2018年10月13日 下午7:06:23
 */
public class User implements Serializable {
	private static final long serialVersionUID = -593997834674924702L;
	
	
	private Integer id;
	private String username;
	private String email;
	private String password;
	private String salt;
	
	private String profile;
	private String nickname;
	private String sign;
	private String imagename;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * @return the imagename
	 */
	public String getImagename() {
		return imagename;
	}
	/**
	 * @param imagename the imagename to set
	 */
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = String.format("Bloger{id=%d, username=%s, password=%s, profile=%s"
				+ "nickname=%s, sign=%s, imagename=%s", 
				id, username, password, profile, nickname, sign, imagename);
		return string;
	}
	
}
