package com.business.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author duck
 * 
 */
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String passWord;
	private Integer roleId;
	private Integer sex;
	private String photoPath;
	private Date birthday;
	private Integer provinceId;
	private Integer cityId;
	private String email;
	private Integer score;
	private Date lastLoginDate;
	private Date registDate;
	private String comment;
	
	public UserInfo(){
		
	}
	public UserInfo(Integer userId, String userName, String passWord,
			Integer roleId, Integer sex, String photoPath, Date birthday,
			Integer provinceId, Integer cityId, String email, Integer score,
			Date lastLoginDate, Date registDate, String comment) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.roleId = roleId;
		this.sex = sex;
		this.photoPath = photoPath;
		this.birthday = birthday;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.email = email;
		this.score = score;
		this.lastLoginDate = lastLoginDate;
		this.registDate = registDate;
		this.comment = comment;
	}

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



}
