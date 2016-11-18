package com.xj.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xj.util.DBUtil;
import com.xj.vo.ShenQingPartInfo;

public class ShenQingPartDao 
{
	private DBUtil m_db = null;
	private String m_repairPart = null;
	private List<String> m_repairPartParam = null;
	
	public ShenQingPartDao()
	{
		m_db = DBUtil.getInstance();
		m_repairPart = "repair_part";
		m_repairPartParam = new ArrayList<String>();
		m_repairPartParam.add("(repair_id");
		m_repairPartParam.add("part_id");
		m_repairPartParam.add("repair_part_num");
	}
	public List<ShenQingPartInfo> queryInfo()
	{
		//System.out.println(">>>>>> ShenQingPartDao:queryInfo[Start]");
		String sql = "select * from "+m_repairPart+";";
		ResultSet res = null;
		m_db.getConnection();
		//System.out.println(">>>>>> ShenQingPartDao:getConnection[Start]");
		res = m_db.query(sql, null);
		List<ShenQingPartInfo> list = new ArrayList<ShenQingPartInfo>();
		//System.out.println(">>>>>> ShenQingPartDao:query[Start]");
		try
		{
			while (res.next())
			{
				ShenQingPartInfo h = new ShenQingPartInfo();
				h.setRepair_id(res.getString("repair_id"));
				h.setPart_id(res.getString(m_repairPartParam.get(1)));
				h.setNum(res.getInt(m_repairPartParam.get(2)));
				list.add(h);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally
		{
			m_db.close();
		}
		//System.out.println(">>>>>> ShenQingPartDao:close[Start]"+list.size());
		return list;
	}
	public void addInfo(ShenQingPartInfo h)
	{	
		//System.out.println(">>>>>> ShenQingPartDao:addInfo[Start]"+repair_id+":"+h.getId()+":"+h.getNum());
		m_db.getConnection();
		//System.out.println(">>>>>> ShenQingPartDao:addInfo[getConnection]");
		String sql = "insert into "+m_repairPart+" values(?,?,?);";
		List<Object> param = new ArrayList<Object>();
		param.add(h.getRepair_id());
		param.add(h.getPart_id());
		param.add(h.getNum());
		m_db.update(sql, param);
		//System.out.println(">>>>>> ShenQingPartDao:addInfo[update]");
		/*
		List<ResourceInfo> tmp = h.getData();
		for (int i = 0; i<tmp.size(); i++)
		{
			sql = "insert into "+m_repairPart+" values(?,?,?);";
			param.clear();
			param.add(h.getId());
			param.add(tmp.get(i).getId());
			param.add(tmp.get(i).getNum());
			m_db.update(sql, param);
		}
		*/
		m_db.close();
		//System.out.println(">>>>>> ShenQingPartDao:addInfo[close]");
	}
	
	public List<ShenQingPartInfo> queryInfoByRepairId(String args)
	{
		m_db.getConnection();
		String sql = "select * from "+m_repairPart+" where repair_id = ?;";
		List<Object> param = new ArrayList<Object>();
		param.add(args);
		ResultSet res = m_db.query(sql,param);
		List<ShenQingPartInfo> list = new ArrayList<ShenQingPartInfo>();
		try
		{
			while(res.next())
			{
				ShenQingPartInfo h = new ShenQingPartInfo();
				h.setRepair_id(res.getString("repair_id"));
				h.setPart_id(res.getString(m_repairPartParam.get(1)));
				h.setNum(res.getInt(m_repairPartParam.get(2)));
				list.add(h);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			m_db.close();
		}
		return list;
	}
	
	public List<ShenQingPartInfo> queryInfoBy(int key,String args)
	{
		m_db.getConnection();
	//	String sql = "select * from "+m_repairPart+" where repair_id = ?;";
		String sql = "select * from "+m_repairPart+" where "+m_repairPartParam.get(key)+" = ?;";
		List<Object> param = new ArrayList<Object>();
		param.add(args);
		ResultSet res = m_db.query(sql,param);
		List<ShenQingPartInfo> list = new ArrayList<ShenQingPartInfo>();
		try
		{
			while(res.next())
			{
				ShenQingPartInfo h = new ShenQingPartInfo();
				h.setRepair_id(res.getString("repair_id"));
				h.setPart_id(res.getString(m_repairPartParam.get(1)));
				h.setNum(res.getInt(m_repairPartParam.get(2)));
				list.add(h);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			m_db.close();
		}
		System.out.println(">>>>>> ShenQingPartDao:close[Start]"+list.size());
		return list;
	}
}
