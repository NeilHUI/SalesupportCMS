package com.xj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.xj.dao.service.PersonnelService;
import com.xj.dao.service.RepairService;
import com.xj.vo.Personnel;
import com.xj.vo.Repair;

public class SerPerAction {
	private List<Repair> list1= new ArrayList<Repair>();
	private Repair r = new Repair();
	private PersonnelService perSer = new PersonnelService();
	private RepairService repSer = new RepairService();
	private Personnel s = new Personnel();
	private String id;
	
	//验证登录
	public String login() throws Exception{
		String id;
		if((id=perSer.valUser(s))!=""){
			
			//在session中保存登录成功的用户名
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("sess_Ser", s.getP_Name());
			querryAllNo();
			return "login_success";
		}else{
			return "login_false";
		}
	}
    public List<Repair> getList1() {
		return list1;
	}
	public void setList1(List<Repair> list1) {
		this.list1 = list1;
	}
	public Repair getR() {
		return r;
	}
	public void setR(Repair r) {
		this.r = r;
	}
	public PersonnelService getPerSer() {
		return perSer;
	}
	public void setPerSer(PersonnelService perSer) {
		this.perSer = perSer;
	}
	public RepairService getRepSer() {
		return repSer;
	}
	public void setRepSer(RepairService repSer) {
		this.repSer = repSer;
	}
	public Personnel getS() {
		return s;
	}
	public void setS(Personnel s) {
		this.s = s;
	}
	//logout
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("sess_Ser");
		return "login_success";
	}
	//抢单
	public String qiangdan(){
		
		return "qd_success";
	}
	public String querryAllNo() throws Exception{
		list1 = repSer.querryAllNo();
		return "serlistTable";
	}
	//查询改维修人员下的订单
	public String querryAllU() throws Exception{
		list1 = repSer.querryAllU(id);
		return "serlistTable";
	}
}
