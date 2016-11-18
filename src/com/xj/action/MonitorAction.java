package com.xj.action;

import java.util.ArrayList;
import java.util.List;

import com.xj.dao.service.RepairService;
import com.xj.vo.Record;
import com.xj.vo.Repair;

public class MonitorAction {

	private RepairService reServiec = new RepairService();
	private List<Repair> listrepair = new ArrayList<Repair>();
	private List<Record> listRecord = new ArrayList<Record>();	

	private Repair myrepair = new Repair();

	public String querys() {
		List<Repair> currentlist = reServiec.QueryAllRepair();
		for (Repair a : currentlist) {
			if (a.getRepair_ISY() == 1) {// 审核通过
				listrepair.add(a);
			}
		}		
		return "getall";
	}

	private String[] histor = { "申请维修订单", "维修订单审核通过", "开始维修", "维修正在处理中······",
			"维修已完成", "用户已评论" };

	public String findhistory() {
		String id = myrepair.getRepair_ID();
		Repair curepair = reServiec.QueryRepair(id);
		String deviceSN=curepair.getRepair_SN();
		boolean flag = false;
		if (curepair.getRepair_Odertime() != null) {
			Record thisrecord0=new Record();
			thisrecord0.setCurrentname(histor[0]);
			thisrecord0.setCurrenttime(curepair.getRepair_Odertime());
			thisrecord0.setDeviceSN(deviceSN);
			listRecord.add(thisrecord0);
			flag = true;
		}
		if (flag) {
			Record thisrecordw=new Record();
			thisrecordw.setCurrentname(histor[1]);
			thisrecordw.setCurrenttime(curepair.getRepair_Odertime());
			thisrecordw.setDeviceSN(deviceSN);
			listRecord.add(thisrecordw);
		} else {
			flag = false;
		}

		if (curepair.getRepair_StartT() != null && flag) {
			Record thisrecord2=new Record();
			thisrecord2.setCurrentname(histor[2]);
			thisrecord2.setCurrenttime(curepair.getRepair_StartT());
			thisrecord2.setDeviceSN(deviceSN);
			listRecord.add(thisrecord2);
		} else {
			flag = false;
		}
		if (curepair.getRepair_State().equals("2") && flag) {
			Record thisrecord3=new Record();
			thisrecord3.setCurrentname(histor[3]);
			thisrecord3.setCurrenttime(curepair.getRepair_StartT());
			thisrecord3.setDeviceSN(deviceSN);
			listRecord.add(thisrecord3);
		} else {
			flag = false;
		}
		if (curepair.getRepair_EndT() != null && flag) {
			Record thisrecord4=new Record();
			thisrecord4.setCurrentname(histor[4]);
			thisrecord4.setCurrenttime(curepair.getRepair_EndT());
			thisrecord4.setDeviceSN(deviceSN);
			listRecord.add(thisrecord4);
		} else {
			flag = false;
		}
		if (flag) {
			Record thisrecordq=new Record();
			thisrecordq.setCurrentname(histor[5]);
			thisrecordq.setCurrenttime(curepair.getRepair_Odertime());
			thisrecordq.setDeviceSN(deviceSN);
			listRecord.add(thisrecordq);
		}
		querys();
		return "getall";
	}

	public List<Record> getListRecord() {
		return listRecord;
	}

	public void setListRecord(List<Record> listRecord) {
		this.listRecord = listRecord;
	}
	public Repair getMyrepair() {
		return myrepair;
	}

	public void setMyrepair(Repair myrepair) {
		this.myrepair = myrepair;
	}

	public List<Repair> getListrepair() {
		return listrepair;
	}

	public void setListrepair(List<Repair> listrepair) {
		this.listrepair = listrepair;
	}

}
