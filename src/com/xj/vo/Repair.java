package com.xj.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Repair {
	private String Repair_ID;
	private int Repair_ISY;
	private Timestamp Repair_StartT;
	private Timestamp Repair_EndT;
	private String Order_ID;
	private String P_ID;
	private String Repair_State;
	private Timestamp Repair_Odertime;
	private String Repair_Tel;
	private String Repair_Adress;
	private String Repair_SN;
	private String Repair_Des;
	
	public String getRepair_Des() {
		return Repair_Des;
	}
	public void setRepair_Des(String repair_Des) {
		Repair_Des = repair_Des;
	}
	public Timestamp getRepair_Odertime() {
		return Repair_Odertime;
	}
	public void setRepair_Odertime(Timestamp repair_Odertime) {
		Repair_Odertime = repair_Odertime;
	}
	public String getRepair_Tel() {
		return Repair_Tel;
	}
	public void setRepair_Tel(String repair_Tel) {
		Repair_Tel = repair_Tel;
	}
	public String getRepair_Adress() {
		return Repair_Adress;
	}
	public void setRepair_Adress(String repair_Adress) {
		Repair_Adress = repair_Adress;
	}
	public String getRepair_SN() {
		return Repair_SN;
	}
	public void setRepair_SN(String repair_SN) {
		Repair_SN = repair_SN;
	}
	public String getRepair_ID() {
		return Repair_ID;
	}
	public void setRepair_ID(String repair_ID) {
		Repair_ID = repair_ID;
	}
	public int getRepair_ISY() {
		return Repair_ISY;
	}
	public void setRepair_ISY(int repair_ISY) {
		Repair_ISY = repair_ISY;
	}
	public Timestamp getRepair_StartT() {
		return Repair_StartT;
	}
	public void setRepair_StartT(Timestamp repair_StartT) {
		Repair_StartT = repair_StartT;
	}
	public Timestamp getRepair_EndT() {
		return Repair_EndT;
	}
	public void setRepair_EndT(Timestamp repair_EndT) {
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
