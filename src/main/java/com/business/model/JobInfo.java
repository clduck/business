package com.business.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author cl TODO 招聘信息类 2012-6-5
 */
public class JobInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer jobID;
	private String jobName;
	private Integer viewFlag;
	private String jobAddress;
	private String pay;
	private Integer jobNumber;
	private String responsibility;
	private String requirement;
	private Date startDate;
	private Date endDate;
	private Integer clickNumber;
	private Date addTime;
	private Date updateTime;
	private String employer;
	private Integer apply;
	private String contact;
	private String tel;
	private String address;
	private String postCode;
	private String email;
	private Integer status;

	public Integer getJobID() {
		return jobID;
	}

	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(Integer viewFlag) {
		this.viewFlag = viewFlag;
	}

	public String getJobAddress() {
		return jobAddress;
	}

	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}

	public Integer getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Integer jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public Integer getApply() {
		return apply;
	}

	public void setApply(Integer apply) {
		this.apply = apply;
	}

}
