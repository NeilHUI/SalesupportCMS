package com.xj.action;

import java.util.ArrayList;
import java.util.List;

import com.xj.dao.service.AdminService;
import com.xj.dao.service.OrderService;
import com.xj.dao.service.PersonnelService;
import com.xj.dao.service.RepairService;
import com.xj.vo.Admin;
import com.xj.vo.Order;
import com.xj.vo.Personnel;
import com.xj.vo.Repair;
import com.xj.vo.Repair_order;

public class AdminAction {
	private AdminService adService = new AdminService();
	private RepairService reServiec=new RepairService();
	private OrderService orService=new OrderService();
	private PersonnelService peService=new PersonnelService();
	private List<Repair_order> list = new ArrayList<Repair_order>();
	private Admin ad = new Admin();
	
	public Admin getAd() {
		return ad;
	}

	public void setAd(Admin ad) {
		this.ad = ad;
	}

	public String checkPass(){
		Admin adcur;
		adcur=adService.QueryAdmin(ad.getAdmin_Name());
		if(adcur.getAdmin_ID()==null||!adcur.getAdmin_Pass().equals(ad.getAdmin_Pass())){
			return "error";			
		}else{
			//queryOrder();
			return "index";
		}
	}
	public List<Repair_order> getList() {
		return list;
	}

	public void setList(List<Repair_order> list) {
		this.list = list;
	}

	public String queryOrder(){
			
		List<Repair> listRepair=new ArrayList<Repair>();
		listRepair=reServiec.QueryAllRepair();
		for(int i=0;i<listRepair.size();i++){
			Repair_order ro=new Repair_order();
			ro.setStartTime(listRepair.get(i).getRepair_StartT());
			ro.setEndTime(listRepair.get(i).getRepair_EndT());
			ro.setState(listRepair.get(i).getRepair_State());
			
			String orderid=listRepair.get(i).getOrder_ID();
			Order order=orService.QueryOrder(orderid);
			ro.setOrderName(order.getOrder_Name());
			
			String pid=listRepair.get(i).getP_ID();
			Personnel po=peService.QueryPersonnel(pid);
			ro.setPName(po.getP_Name());
			list.add(ro);
		}	
		
		return "listRepair";
	}
}
