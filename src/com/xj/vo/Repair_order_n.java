package com.xj.vo;

import java.sql.Timestamp;

public class Repair_order_n {
	
	private String repairID;
	
	private String orderName;
	private String orderDes;
	private Timestamp orderTime;
	private String pname;
	private String phone;
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRepairID() {
		return repairID;
	}
	public void setRepairID(String repairID) {
		this.repairID = repairID;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderDes() {
		return orderDes;
	}
	public void setOrderDes(String orderDes) {
		this.orderDes = orderDes;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	

}
