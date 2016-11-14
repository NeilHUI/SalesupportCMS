package com.xj.dao;

import java.util.List;

import com.xj.vo.Personnel;



public interface IPersonnel {
	public List<Personnel> QueryAllPersonnel();

	public Personnel QueryPersonnelByID(int id);

	public void InsertPersonnel(Personnel p);

	public void DeletePersonnel(int id);

	public void UpdatePersonnel(Personnel p);
}
