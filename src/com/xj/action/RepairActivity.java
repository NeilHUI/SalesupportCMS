package com.xj.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import com.xj.dao.service.RepairService;
import com.xj.vo.Repair;

public class RepairActivity {
	private RepairService repSer = new RepairService();
	private List<Repair> list= new ArrayList<Repair>();
	private Repair r = new Repair();
	private String r_ID ;
	public String getR_ID() {
		return r_ID;
	}
	public void setR_ID(String r_ID) {
		this.r_ID = r_ID;
	}
	//查询全部 
	public String queryDetail() throws Exception {
		r = repSer.QueryRepair(r_ID);
		return "querry_success";
	}
	//查询用户下的维修单
	public String queryById() throws Exception{
		list = repSer.querryByUser(r_ID);
		return "listTable";
	}
	public String add() throws Exception {
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		r.setRepair_ID(UUID.randomUUID().toString());
		r.setRepair_StartT(d);
		r.setRepair_ISY(0);
		r.setRepair_State("1");

		r.setOrder_ID(r_ID+"@"+r.getOrder_ID());
		repSer.InsertRepair(r);
		return queryById();
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
