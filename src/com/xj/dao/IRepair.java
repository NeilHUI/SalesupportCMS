package com.xj.dao;

import java.util.List;

import com.xj.vo.Repair;

public interface IRepair {

	public List<Repair> QueryAllRepair();

	public Repair QueryRepairByID(int id);

	public void InsertRepair(Repair r);

	public void DeleteRepair(int id);

	public void UpdateRepair(Repair r);
}
