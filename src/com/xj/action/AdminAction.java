package com.xj.action;

import java.util.ArrayList;
import java.util.List;

import com.xj.dao.service.AdminService;
import com.xj.dao.service.OrderService;
import com.xj.dao.service.PersonnelService;
import com.xj.dao.service.RepairService;
import com.xj.dao.service.UserService;
import com.xj.vo.Admin;
import com.xj.vo.Order;
import com.xj.vo.Personnel;
import com.xj.vo.Repair;
import com.xj.vo.Repair_order;
import com.xj.vo.Repair_order_n;
import com.xj.vo.User;

public class AdminAction {
	private AdminService adService = new AdminService();
	private RepairService reServiec=new RepairService();
	private OrderService orService=new OrderService();
	private UserService usService=new UserService();
	private PersonnelService peService=new PersonnelService();
	private List<Repair_order> listY = new ArrayList<Repair_order>();
	private List<Repair_order_n> listN=new ArrayList<Repair_order_n>();
	private Repair repair=new Repair();
	
	public Repair getRepair() {
		return repair;
	}

	public void setRepair(Repair repair) {
		this.repair = repair;
	}

	public List<Repair_order> getListY() {
		return listY;
	}

	public void setListY(List<Repair_order> listY) {
		this.listY = listY;
	}

	public List<Repair_order_n> getListN() {
		return listN;
	}

	public void setListN(List<Repair_order_n> listN) {
		this.listN = listN;
	}

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

	public String queryOrder(){			
		List<Repair> listRepair=new ArrayList<Repair>();
		listRepair=reServiec.QueryAllRepair();
		for(int i=0;i<listRepair.size();i++){			
			if(listRepair.get(i).getRepair_ISY()==1)
			{		
				Repair_order ro=new Repair_order();
				ro.setRepairID(listRepair.get(i).getRepair_ID());
				ro.setStartTime(listRepair.get(i).getRepair_StartT());
				ro.setEndTime(listRepair.get(i).getRepair_EndT());
				ro.setState(listRepair.get(i).getRepair_State());
				ro.setOrderName(listRepair.get(i).getRepair_Des());
				
				String pid=listRepair.get(i).getP_ID();
				Personnel po=peService.QueryPersonnel(pid);
				ro.setPName(po.getP_Name());
				
				listY.add(ro);
			}
			else{
				Repair_order_n ron=new Repair_order_n();
				
				ron.setRepairID(listRepair.get(i).getRepair_ID());
				ron.setOrderDes(listRepair.get(i).getRepair_Des());
				ron.setOrderName(listRepair.get(i).getRepair_SN());
				ron.setOrderTime(listRepair.get(i).getRepair_Odertime());
				ron.setPhone(listRepair.get(i).getRepair_Tel());
				ron.setpName(listRepair.get(i).getOrder_ID());
				
				listN.add(ron);
			}
		}	
		
		return "listRepair";
	}
	public String updaterepair(){
		String repair_order_ID=repair.getRepair_ID();
		Repair uprepair=reServiec.QueryRepair(repair_order_ID);
		uprepair.setRepair_ISY(1);//Í¨¹ýÉóºË
		reServiec.UpdateRepair(uprepair);
		return "listRepair";
	}
	public String deleterepair(){
		String repair_order_ID=repair.getRepair_ID();
		reServiec.DeleteRepair(repair_order_ID);
		return "listRepair";
	}
}
