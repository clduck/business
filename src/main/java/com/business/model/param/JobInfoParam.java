package com.business.model.param;

public class JobInfoParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startTime; // 起始时间
	private String endTime; // 结束时间
	private String jobName;// 模糊搜索产品名称

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
