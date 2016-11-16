package com.xj.vo;

import java.sql.Date;

public class Repair {
	private String Repair_ID;
	private String Repair_ISY;
	private Date Repair_StartT;
	private Date Repair_EndT;
	private String Order_ID;
	private String P_ID;
	private String Repair_State;
	
	public String getRepair_ID() {
		return Repair_ID;
	}
	public void setRepair_ID(String repair_ID) {
		Repair_ID = repair_ID;
	}
	public String getRepair_ISY() {
		return Repair_ISY;
	}
	public void setRepair_ISY(String repair_ISY) {
		Repair_ISY = repair_ISY;
	}
	public Date getRepair_StartT() {
		return Repair_StartT;
	}
	public void setRepair_StartT(Date repair_StartT) {
		Repair_StartT = repair_StartT;
	}
	public Date getRepair_EndT() {
		return Repair_EndT;
	}
	public void setRepair_EndT(Date repair_EndT) {
		Repair_EndT = repair_EndT;
	}
	public String getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}
	public String getP_ID() {
		return P_ID;
	}
	public void setP_ID(String p_ID) {
		P_ID = p_ID;
	}
	public String getRepair_State() {
		return Repair_State;
	}
	public void setRepair_State(String repair_State) {
		Repair_State = repair_State;
	}
	
	
	
	
}
