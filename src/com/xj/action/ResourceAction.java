package com.xj.action;

import java.util.List;
import java.util.ArrayList;

//import ResourceInfo;
import com.xj.dao.service.ResourceService;
import com.xj.vo.ResourceInfo;


public class ResourceAction 
{
	private ResourceService ri = new ResourceService();
	private List<ResourceInfo> part_list = new ArrayList<ResourceInfo>();
	private ResourceInfo h = new ResourceInfo();
	private int aa;
	
	
	public String queryAll() throws Exception
	{
		ResourceInfo r = null;
		part_list = ri.queryInfo();
		setAa(1);
		for (int i = 0; i < part_list.size(); i++)
		{
			r = part_list.get(i);
			System.out.println("!!!!id:"+r.getId()+", name:"+r.getName()+", amount:"+r.getNum());
		}
		return "part_all";
	}

	public String preUpdate() throws Exception {
		//h.setId("0123");
		h = ri.queryInfoById(h.getId());
		//System.out.println("id:"+h.getId()+", name:"+h.getName()+", amount:"+h.getNum());
		return "part_update";
	}
	
	public String add() throws Exception {
		System.out.println("id:"+h.getId()+", name:"+h.getName()+", amount:"+h.getNum());
		ri.addInfo(h);
		return queryAll();
	}
	
	public String delete() throws Exception {
		ri.delInfo(h.getId());
		return queryAll();
	}
	
	public String update() throws Exception {
		ri.updataInfo(h);
		return queryAll();
	}
/*
	public static void main(String args[])
	{
		ResourceAction r = new ResourceAction();
		ResourceService rdao = new ResourceService();
		try
		{
			r.preUpdate();
		}
		catch (Exception e)
		{
		}
	}
*/
	public List<ResourceInfo> getPart_list()
	{
		return part_list;
	}

	public void setPart_list(List<ResourceInfo> list)
	{
		this.part_list = list;
	}

	public ResourceInfo getH()
	{
		return h;
	}

	public void setH(ResourceInfo h) 
	{
		this.h = h;
	}

	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}
}
