package com.productitem.model;

public class ProductItemVO implements java.io.Serializable {
	
	private Integer pdtOrderId;
	private Integer pdtId;
	private Integer pdtPrice;
	private String pdtName;
	private Integer orderQty;
	
	public Integer getPdtOrderId() {
		return pdtOrderId;
	}
	public void setPdtOrderId(Integer pdtOrderId) {
		this.pdtOrderId = pdtOrderId;
	}
	public Integer getPdtId() {
		return pdtId;
	}
	public void setPdtId(Integer pdtId) {
		this.pdtId = pdtId;
	}
	public Integer getPdtPrice() {
		return pdtPrice;
	}
	public void setPdtPrice(Integer pdtPrice) {
		this.pdtPrice = pdtPrice;
	}
	public String getPdtName() {
		return pdtName;
	}
	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}
	public Integer getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(Integer orderQty) {
		this.orderQty = orderQty;
	}
	
	
	
}
