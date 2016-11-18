package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.PersonnelDao;
import com.xj.vo.Personnel;

public class PersonnelService {

private PersonnelDao Pdao=new PersonnelDao();
	
	public List<Personnel> QueryAllPersonnel(){
		return Pdao.QueryAllPersonnel();
	}
	public String valUser(Personnel s){
		return Pdao.valUser(s);
		
	}
	public Personnel QueryPersonnel(String id){
		return Pdao.QueryPersonnelByID(id);
	}
	
	public void InsertPersonnel(Personnel p){
		Pdao.InsertPersonnel(p);
	}
	
	public void DeletePersonnel(String id){
		Pdao.DeletePersonnel(id);
	}
	
	public void UpdatePersonnel(Personnel p){
		Pdao.UpdatePersonnel(p);
	}
}
