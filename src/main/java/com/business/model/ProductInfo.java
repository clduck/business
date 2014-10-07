package com.business.model;

import java.io.Serializable;
import java.util.Date;

public class ProductInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productID;
	private String productName;
	private Integer viewFlag;
	private Integer sortID;
	private String sortName;
	private String sortPath;
	private String productNo;    // 产品编号
	private String productModel; // 产品系列
	private Double N_Price;      //标准价格
	private String N_PriceStr;
	private Double P_Price;      //优惠价格
	private String P_PriceStr;
	private Integer stock;       //库存数
	private String unit;         // 货币编码
	private Integer commendFlag; //公司推荐
	private Integer newFlag;     //新品推荐
	private String maker;        //制造商
	private String groupID;
	private String exclusive;    //归属
	private String smallPic;
	private String bigPic;
	private String content;
	private Integer clickNumber;
	private Date addTime;
	private String addTimeStr;
	private Date updateTime;
	private String updateTimeStr;
	private Integer sortID2;
	private String sortPath2;
	private Integer sequence;
	private String seoKeywords;
	private String seoDescription;
	private Integer status;

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(Integer viewFlag) {
		this.viewFlag = viewFlag;
	}

	public Integer getSortID() {
		return sortID;
	}

	public void setSortID(Integer sortID) {
		this.sortID = sortID;
	}

	public String getSortPath() {
		return sortPath;
	}

	public void setSortPath(String sortPath) {
		this.sortPath = sortPath;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public Double getN_Price() {
		return N_Price;
	}

	public void setN_Price(Double n_Price) {
		N_Price = n_Price;
	}

	public Double getP_Price() {
		return P_Price;
	}

	public void setP_Price(Double p_Price) {
		P_Price = p_Price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	public Integer getCommendFlag() {
		return commendFlag;
	}

	public void setCommendFlag(Integer commendFlag) {
		this.commendFlag = commendFlag;
	}

	public Integer getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(Integer newFlag) {
		this.newFlag = newFlag;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getExclusive() {
		return exclusive;
	}

	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}

	public String getSmallPic() {
		return smallPic;
	}

	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}

	public String getBigPic() {
		return bigPic;
	}

	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Integer getSortID2() {
		return sortID2;
	}

	public void setSortID2(Integer sortID2) {
		this.sortID2 = sortID2;
	}

	public String getSortPath2() {
		return sortPath2;
	}

	public void setSortPath2(String sortPath2) {
		this.sortPath2 = sortPath2;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getAddTimeStr() {
		return addTimeStr;
	}

	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public String getN_PriceStr() {
		return N_PriceStr;
	}

	public void setN_PriceStr(String n_PriceStr) {
		N_PriceStr = n_PriceStr;
	}

	public String getP_PriceStr() {
		return P_PriceStr;
	}

	public void setP_PriceStr(String p_PriceStr) {
		P_PriceStr = p_PriceStr;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

}
