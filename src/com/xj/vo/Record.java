package com.xj.vo;

import java.sql.Timestamp;

public class Record {

	private String currentname;
	private Timestamp currenttime;
	private String deviceSN;
	public String getDeviceSN() {
		return deviceSN;
	}
	public void setDeviceSN(String deviceSN) {
		this.deviceSN = deviceSN;
	}
	public String getCurrentname() {
		return currentname;
	}
	public void setCurrentname(String currentname) {
		this.currentname = currentname;
	}
	public Timestamp getCurrenttime() {
		return currenttime;
	}
	public void setCurrenttime(Timestamp currenttime) {
		this.currenttime = currenttime;
	}
}
