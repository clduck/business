package com.business.model.param;

public class DownloadParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startTime; // 起始时间
	private String endTime; // 结束时间
	private String downloadName;// 模糊搜索产品名称
	private Integer downloadTypeID; // 产品类别ID

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

	public String getDownloadName() {
		return downloadName;
	}

	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}

	public Integer getDownloadTypeID() {
		return downloadTypeID;
	}

	public void setDownloadTypeID(Integer downloadTypeID) {
		this.downloadTypeID = downloadTypeID;
	}

}
