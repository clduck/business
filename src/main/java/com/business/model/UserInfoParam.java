package com.business.model;

import java.io.Serializable;

public class UserInfoParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String password2;
	private String gendernew;
	private String email;
	private String questionid;

	public UserInfoParam(String username, String password, String password2,
			String gendernew, String email, String questionid, String answer,
			String birthday, String site) {
		super();
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.gendernew = gendernew;
		this.email = email;
		this.questionid = questionid;
		this.answer = answer;
		this.birthday = birthday;
		this.site = site;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getGendernew() {
		return gendernew;
	}

	public void setGendernew(String gendernew) {
		this.gendernew = gendernew;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	private String answer;
	private String birthday;
	private String site;

}
