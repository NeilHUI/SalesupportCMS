package com.xj.action;

import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import com.xj.dao.service.ShenQingPartService;
import com.xj.dao.service.ShenQingService;
import com.xj.dao.service.ResourceService;
import com.xj.vo.ShenQingInfo;
import com.xj.vo.ResourceInfo;
import com.xj.vo.ShenQingPartInfo;
//import ResourceInfo;

public class ShenQingAction 
{
	private ShenQingService ri = new ShenQingService();
	private ResourceService m_rs = new ResourceService();
	private ShenQingPartService m_sqps = new ShenQingPartService();
	
	private List<ShenQingInfo> list = new ArrayList<ShenQingInfo>();
	private ShenQingInfo sq = new ShenQingInfo();
	
	private ResourceInfo r = new ResourceInfo();
	private List<ResourceInfo> list_part = new ArrayList<ResourceInfo>();
	private String res_add = new String();
	private String del_index = new String();
	
	private ShenQingPartInfo sqpi = new ShenQingPartInfo();
	private List<ShenQingPartInfo> list_sqpi = new ArrayList<ShenQingPartInfo>();
	
	private List<String> res_queryBy = new ArrayList<String>();
	
	
	public String queryByPartId() throws Exception
	{
		System.out.println(">>>>[start]"+del_index+sq.getManId());
		if (del_index.isEmpty()) return "ShenQing_query";
		res_queryBy.clear();
		list_sqpi.clear();
		res_queryBy.add(del_index+"物品使用情况如下");
		list_sqpi = m_sqps.queryInfoBy(1,del_index);
		System.out.println(">>>>"+list_sqpi.size());
		for (int i = 0;list_sqpi!=null && i < list_sqpi.size();i++)
		{
			sq = ri.queryInfoById(list_sqpi.get(i).getRepair_id());
			String tmp = new String("申请ID："+ sq.getId()+" 用途："+sq.getAddr()+" 时间："+sq.getTime().toString()+" 使用个数为:"+list_sqpi.get(i).getNum());
			System.out.println("+++"+tmp);
			res_queryBy.add(tmp);
		}
		return "ShenQing_query_byManId";
	}
	
	public String queryByManId() throws Exception
	{
		//System.out.println(">>>>"+del_index+sq.getManId());
		
		if (del_index.isEmpty()) return "ShenQing_query";
		res_queryBy.add(del_index+"维修员使用的物品如下");
		list = ri.queryInfoBy(1,del_index);
		for (int i = 0;list!=null && i < list.size();i++)
		{
			String tmp = new String();
			tmp = tmp + "申请ID："+ list.get(i).getId()+" 用途："+list.get(i).getAddr()+" 时间："+list.get(i).getTime().toString()+"<br/>使用物品如下:<br/>";
			//System.out.println(">>>>"+tmp);
			list_sqpi = m_sqps.queryInfoByRepairId(list.get(i).getId());
			for (int j = 0;list_sqpi!=null && j < list_sqpi.size();j++)
			{
				tmp = tmp+""+(j+1)+".物品id："+list_sqpi.get(j).getPart_id()+" 数量："+list_sqpi.get(j).getNum()+"<br/>";
			}
			//System.out.println(">>>>"+tmp);
			res_queryBy.add(tmp);
		}
		return "ShenQing_query_byManId";
	}
	
	public String queryAll() throws Exception
	{
		//ShenQingInfo r = null;
		list = ri.queryInfo();
		/*
		for (int i = 0; i < list.size(); i++)
		{
			r = list.get(i);
			System.out.println("id:"+r.getId()+", manid:"+r.getManId()+", addr:"+r.getAddr()+", time:"+r.getTime());
		}
		*/
		return "ShenQing_all";
	}
	
	public String queryRepairPartAll() throws Exception
	{
		//ShenQingInfo r = null;
		//System.out.println(">>>>>>>queryRepairPartAll");
		setList_sqpi(m_sqps.queryInfo());
		/*
		for (int i = 0; i < list.size(); i++)
		{
			r = list.get(i);
			System.out.println("id:"+r.getId()+", manid:"+r.getManId()+", addr:"+r.getAddr()+", time:"+r.getTime());
		}
		*/
		return "ShenQing_part_all";
	}

	public String preUpdate() throws Exception
	{
		//sq.setId("0123");
		sq = ri.queryInfoById(sq.getId());
		//System.out.println("id:"+sq.getId()+", name:"+sq.getName()+", amount:"+sq.getNum());
		return "update";
	}
	public String add() throws Exception 
	{
		if (sqpi.getPart_id() == ""||0 == sqpi.getNum()||sq.getManId() == ""||""==sq.getAddr()) 
		{
			setRes_add("填写不能为空");
			System.out.println(getRes_add());
			return "ShenQing_add_res_0";
		}
		
		ResourceInfo tmp = m_rs.queryInfoById(sqpi.getPart_id());
		if(sqpi.getNum() > tmp.getNum())
		{
			setRes_add(sqpi.getPart_id()+"库存不足！！");
			System.out.println(getRes_add());
			return "ShenQing_add_res_0";
		}
		
		sq.setId(Long.toString(System.currentTimeMillis()));
		sq.setTime(new Date(System.currentTimeMillis()));
		ri.addInfo(sq);
		
		ResourceInfo tmp01 = new ResourceInfo();
		tmp01.setId(tmp.getId());
		tmp01.setName(tmp.getName());
		tmp01.setNum(tmp.getNum()-r.getNum());
		m_rs.updataInfo(tmp01);
		
		sqpi.setRepair_id(sq.getId());
		m_sqps.addInfo(sqpi);
		
		setRes_add(sqpi.getPart_id()+"申请成功！！");
		System.out.println(getRes_add());
		return "ShenQing_add_res_0";
	}
/*
	public static void main(String args[])
	{
		ShenQingAction ra = new ShenQingAction();
		ShenQingService rdao = new ShenQingService();
		try
		{
			ra.add();
			ra.queryAll();
		}
		catch (Exception e)
		{
		}
	}
*/
	
	/*
	public String addPart() throws Exception
	{
		if (r.getId() == ""||0 == r.getNum()) 
		{
			setRes_add("填写不能为空");
			return "ShenQing_add";
		}
		ResourceInfo tmp = m_rs.queryInfoById(r.getId());
		
		if(r.getNum()>tmp.getNum())
		{
			setRes_add("库存不足");
		}
		else
		{
			ResourceInfo tmp_r = new ResourceInfo();
			tmp.setId(r.getId());
			tmp.setNum(r.getNum());
			setRes_add("");
			list_part.add(tmp_r);
			r.setId("");
			r.setNum(0);
		}
		return "ShenQing_add";
	}
	
	public String delPart()
	{
		List<ResourceInfo> tmp_list = new ArrayList<ResourceInfo>();
		ResourceInfo tmp = null;
		for (int i = 0; i<list_part.size();i++)
		{
			tmp_list.add(list_part.get(i));
		}
		list_part.clear();
		for (int i = 0; i<tmp_list.size();i++)
		{
			tmp = tmp_list.get(i);
			if (del_index.equals(tmp.getId()))
			{
				continue;
			}
			else
			{
				list_part.add(tmp);
			}
		}
		return "ShenQing_add";
	}
	*/
	public List<ShenQingInfo> getList()
	{
		return list;
	}

	public void setList(List<ShenQingInfo> list)
	{
		this.list = list;
	}
	
	public List<ResourceInfo> getList_part()
	{
		return list_part;
	}

	public void setList_part(List<ResourceInfo> list)
	{
		this.list_part = list;
	}

	public ResourceInfo getR()
	{
		return r;
	}

	public void setR(ResourceInfo r) 
	{
		this.r = r;
	}

	public String getRes_add() {
		return res_add;
	}

	public void setRes_add(String res_add) {
		this.res_add = res_add;
	}

	public String getDel_index() {
		return del_index;
	}

	public void setDel_index(String del_index) {
		this.del_index = del_index;
	}

	public ShenQingInfo getSq() {
		return sq;
	}

	public void setSq(ShenQingInfo sq) {
		this.sq = sq;
	}

	public ShenQingPartInfo getSqpi() {
		return sqpi;
	}

	public void setSqpi(ShenQingPartInfo sqpi) {
		this.sqpi = sqpi;
	}

	public List<ShenQingPartInfo> getList_sqpi() {
		return list_sqpi;
	}

	public void setList_sqpi(List<ShenQingPartInfo> list_sqpi) {
		this.list_sqpi = list_sqpi;
	}

	public List<String> getRes_queryBy() {
		return res_queryBy;
	}

	public void setRes_queryBy(List<String> res_queryBy) {
		this.res_queryBy = res_queryBy;
	}
	
	
	
}
