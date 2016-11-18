package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.RepairDao;
import com.xj.vo.Repair;

public class RepairService {

private RepairDao Rdao=new RepairDao();
	
	public List<Repair> QueryAllRepair(){
		return Rdao.QueryAllRepair();
	}
	
	public Repair QueryRepair(String id){
		return Rdao.QueryRepairByID(id);
	}
	
	public void InsertRepair(Repair a){
		Rdao.InsertRepair(a);
	}
	
	public void DeleteRepair(String id){
		Rdao.DeleteRepair(id);
	}
	
	public void UpdateRepair(Repair a){
		Rdao.UpdateRepair(a);
	}
	public List<Repair> querryByUser(String u){
		return Rdao.QueryByUser(u);
	}
	public List<Repair> querryAllNo(){
		return Rdao.querryAllNo();
	}
	public List<Repair> querryAllU(String u){
		return Rdao.querryAllU(u);
	}
}
