package com.xj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.xj.dao.service.FeedBackService;
import com.xj.dao.service.PersonnelService;
import com.xj.dao.service.RepairService;
import com.xj.vo.FeedBack;
import com.xj.vo.Personnel;
import com.xj.vo.Repair;

public class SystemAction {
	private PersonnelService peService=new PersonnelService();
	private RepairService reServiec=new RepairService();
	private List<Personnel> listrepairMan=new ArrayList<Personnel>();//存储维修人员名单
	private List<Repair> relist = new ArrayList<Repair>();//存储维修订单
	private Repair chooseRepair=new Repair();
	private Personnel repairper=new Personnel();
	

	/**
	 * 获得通过审核的尚未安排的维修订单
	 */
	public String querySystemPlan(){
		
		listrepairMan = peService.QueryAllPersonnel();
		
		List<Repair> rep = new ArrayList<Repair>();
		rep=reServiec.QueryAllRepair();
		for(int i=0;i<rep.size();i++){
			if(rep.get(i).getRepair_ISY()==1 && rep.get(i).getRepair_State().equals("1")){//审核通过未安排维修人员
				relist.add(rep.get(i));
			}
		}
		return "findall";
	}

	public String submitPlan(){ //提交 给修订单安排的维修人员
		String personnelid=repairper.getP_ID(); //获得维修人员编号
		String repair_ID=chooseRepair.getRepair_ID(); //获得维修表得维修id.
		
		//生成反馈表主键编号    之后将维修人员编号插入反馈表			
		FeedBack fbone=new FeedBack();
		fbone.setFB_ID(UUID.randomUUID().toString());
		fbone.setP_ID(personnelid);
		fbone.setOrder_ID(repair_ID);
		FeedBackService fbservice=new FeedBackService();
		fbservice.InsertFeedBack(fbone);
		
		Repair repairone=reServiec.QueryRepair(repair_ID);
		repairone.setP_ID(fbone.getFB_ID());
		repairone.setRepair_State("2");//正在维修状态
		reServiec.UpdateRepair(repairone);
		
		
		return "findall";
	}

	public List<Personnel> getListrepairMan() {
		return listrepairMan;
	}

	public void setListrepairMan(List<Personnel> listrepairMan) {
		this.listrepairMan = listrepairMan;
	}

	public List<Repair> getRelist() {
		return relist;
	}

	public void setRelist(List<Repair> relist) {
		this.relist = relist;
	}

	public Repair getChooseRepair() {
		return chooseRepair;
	}

	public void setChooseRepair(Repair chooseRepair) {
		this.chooseRepair = chooseRepair;
	}

	public Personnel getRepairper() {
		return repairper;
	}

	public void setRepairper(Personnel repairper) {
		this.repairper = repairper;
	}

	
	
}
