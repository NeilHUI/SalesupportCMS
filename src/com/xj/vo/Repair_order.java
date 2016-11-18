package com.xj.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Repair_order {

	private String repairID;

	private String OrderName;
	private String PName;
	private Timestamp startTime;
	private Timestamp endTime;
	private String state;

	public String getRepairID() {
		return repairID;
	}

	public void setRepairID(String repairID) {
		this.repairID = repairID;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
