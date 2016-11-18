package com.xj.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;
import com.xj.dao.service.FeedBackService;
import com.xj.dao.service.PersonnelService;
import com.xj.dao.service.RepairService;
import com.xj.vo.FeedBack;
import com.xj.vo.Personnel;
import com.xj.vo.Repair;

public class SerPerAction {
	private List<Repair> list1= new ArrayList<Repair>();
	private Repair r = new Repair();
	private PersonnelService perSer = new PersonnelService();
	private RepairService repSer = new RepairService();
	private Personnel s = new Personnel();
	private FeedBackService feeSer =  new FeedBackService();
	private String id;
	private String r_ID;
	private String main_ID;
	
	public FeedBackService getFeeSer() {
		return feeSer;
	}
	public void setFeeSer(FeedBackService feeSer) {
		this.feeSer = feeSer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getR_ID() {
		return r_ID;
	}
	public void setR_ID(String r_ID) {
		this.r_ID = r_ID;
	}
	public String getMain_ID() {
		return main_ID;
	}
	public void setMain_ID(String main_ID) {
		this.main_ID = main_ID;
	}
	//验证登录
	public String login() throws Exception{
		String id;
		if((id=perSer.valUser(s))!=""){
			
			//在session中保存登录成功的用户名
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("sess_Ser", s.getP_Name());
			session.put("sess_id", id);
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
		session.remove("sess_id");
		return "login_success";
	}
	//抢单
	public String qiangdan(){
		FeedBack f = new FeedBack();
		f.setFB_ID(r_ID);
		f.setP_ID(id);
		feeSer.InsertFeedBack(f);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		repSer.updateOne("Repair_OderTime",d, main_ID);
		repSer.updateOne("Repair_State",2, main_ID);


		return "qd_success";
	}
	//完成订单
		public String wancheng(){
			Timestamp d = new Timestamp(System.currentTimeMillis());
			
			repSer.updateOne("Repair_EndT",d, main_ID);
			repSer.updateOne("Repair_State",3, main_ID);
			return "wancheng_success";
		}
	public String querryAllNo() throws Exception{
		list1 = repSer.querryAllNo();
		return "serlistTable";
	}
	//查询维修人员下的订单
	public String querryAllU() throws Exception{
		list1 = repSer.querryAllU(id);
		System.out.println(list1.get(0).getP_ID());
		
		return "serlist";
	}
}
