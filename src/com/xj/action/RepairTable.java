package com.xj.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.xj.dao.service.RepairService;
import com.xj.vo.Repair;

public class RepairTable {
	private RepairService repSer = new RepairService();
	private List<Repair> list= new ArrayList<Repair>();
	private Repair r = new Repair();
	//²éÑ¯È«²¿ 
	public String queryAll() throws Exception {
		
		list = repSer.QueryAllRepair();
		
		return "listTable";
	}
	public String add() throws Exception {
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		r.setRepair_ID(UUID.randomUUID().toString());
		r.setRepair_StartT(d);
		r.setRepair_ISY(0);
		r.setRepair_State("1");
		repSer.InsertRepair(r);
		return queryAll();
	}
	

	public RepairService getRepSer() {
		return repSer;
	}
	public void setRepSer(RepairService repSer) {
		this.repSer = repSer;
	}
	public List<Repair> getList() {
		return list;
	}
	public void setList(List<Repair> list) {
		this.list = list;
	}
	public Repair getR() {
		return r;
	}
	public void setR(Repair r) {
		this.r = r;
	}
}
