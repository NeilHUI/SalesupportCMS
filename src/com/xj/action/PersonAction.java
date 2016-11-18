package com.xj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.xj.dao.service.PersonnelService;
import com.xj.vo.Personnel;

public class PersonAction {
	
	private personone myper =new personone();
	private PersonnelService peService=new PersonnelService();
	private List<Personnel> listPerson=new ArrayList<Personnel>();
	
	public String queryAllPerson(){
		listPerson=peService.QueryAllPersonnel();
		return "ok";
	}
	public String addPersonnel(){
		Personnel pp=new Personnel();
		pp.setP_ID(UUID.randomUUID().toString());
		pp.setP_Name(myper.getName());
		pp.setP_Pass("123456");		
		peService.InsertPersonnel(pp);
		queryAllPerson();
		return "ok";
	}
	public String deletePersonnel(){
		String perid=myper.getId();
		peService.DeletePersonnel(perid);
		queryAllPerson();
		return "ok";
	}
	public String preupdate(){
		String perid=myper.getId();
		Personnel pp=peService.QueryPersonnel(perid);
		myper.setName(pp.getP_Name());
		myper.setId(pp.getP_ID());
		myper.setGrade("ตฺถþื้");
		return "updateok";
	}
	public String updatePersonnel(){
		String perid=myper.getId();
		Personnel pp=new Personnel();
		pp.setP_Name(myper.getName());		
		queryAllPerson();
		return "ok";
	}
	
	
	
	
	public List<Personnel> getListPerson() {
		return listPerson;
	}
	public void setListPerson(List<Personnel> listPerson) {
		this.listPerson = listPerson;
	}
	public personone getMyper() {
		return myper;
	}
	public void setMyper(personone myper) {
		this.myper = myper;
	}

	class personone{
		private String id;
		private String name;
		private String age;
		private String sex;
		private String grade;
		private String descr;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
		
	}
	
	
}
