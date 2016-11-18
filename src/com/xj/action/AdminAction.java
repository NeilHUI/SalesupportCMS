package com.xj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.xj.dao.service.AdminService;
import com.xj.dao.service.PersonnelService;
import com.xj.dao.service.RepairService;
import com.xj.vo.Admin;
import com.xj.vo.Personnel;
import com.xj.vo.Repair;
import com.xj.vo.Repair_order;
import com.xj.vo.Repair_order_n;

public class AdminAction implements SessionAware {

	private AdminService adService = new AdminService();
	private RepairService reServiec = new RepairService();

	private PersonnelService peService = new PersonnelService();
	private List<Repair_order> listY = new ArrayList<Repair_order>();
	private List<Repair_order_n> listN = new ArrayList<Repair_order_n>();
	private Repair arepair = new Repair();

	private Map session;

	public Repair getArepair() {
		return arepair;
	}

	public void setArepair(Repair arepair) {
		this.arepair = arepair;
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

	public String checkPass() {
		Admin adcur;
		adcur = adService.QueryAdmin(ad.getAdmin_Name());
		if (adcur.getAdmin_ID() == null
				|| !adcur.getAdmin_Pass().equals(ad.getAdmin_Pass())) {
			return "error";
		} else {
			// queryOrder();
			this.session.put("USER_NAME", ad.getAdmin_Name());
			return "index";
		}
	}

	public String queryOrder() {
		List<Repair> listRepair = new ArrayList<Repair>();
		listRepair = reServiec.QueryAllRepair();
		for (int i = 0; i < listRepair.size(); i++) {
			if (listRepair.get(i).getRepair_ISY() == 1) {
				Repair_order ro = new Repair_order();
				ro.setRepairID(listRepair.get(i).getRepair_ID());
				ro.setStartTime(listRepair.get(i).getRepair_StartT());
				ro.setEndTime(listRepair.get(i).getRepair_EndT());
				ro.setState(listRepair.get(i).getRepair_State());
				ro.setOrderName(listRepair.get(i).getRepair_SN());

				String pid = listRepair.get(i).getP_ID();
				Personnel po = peService.QueryPersonnel(pid);
				ro.setPName(po.getP_Name());

				listY.add(ro);
			} else {
				Repair_order_n ron = new Repair_order_n();

				ron.setRepairID(listRepair.get(i).getRepair_ID());

				ron.setOrderDes(listRepair.get(i).getRepair_Des());
				ron.setOrderName(listRepair.get(i).getRepair_SN());
				ron.setOrderTime(listRepair.get(i).getRepair_Odertime());
				ron.setPhone(listRepair.get(i).getRepair_Tel());
				String nameone = listRepair.get(i).getOrder_ID();

				//System.out.println(nameone);
				nameone = nameone.replace("user@", "");
				ron.setPname(nameone);

				listN.add(ron);
			}
		}

		return "listRepair";
	}

	public String updaterepair() {
		String repair_order_ID = arepair.getRepair_ID();
		Repair uprepair = reServiec.QueryRepair(repair_order_ID);
		uprepair.setRepair_ISY(1);// Í¨¹ýÉóºË
		reServiec.UpdateRepair(uprepair);
		queryOrder();
		return "listRepair";
	}

	public String deleterepair() {
		String repair_order_ID = arepair.getRepair_ID();
		reServiec.DeleteRepair(repair_order_ID);
		queryOrder();
		return "listRepair";
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}
}
