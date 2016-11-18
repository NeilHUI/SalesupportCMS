package com.xj.dao.impl;

import java.sql.ResultSet;
import java.lang.Exception;
import java.util.List;
import java.util.ArrayList;
//import DBUtil;
import com.xj.util.DBUtil;
import com.xj.vo.ShenQingInfo;

public class ShenQingDao
{
	private DBUtil m_db = null;
	private String m_repair = null;
	private List<String> m_repairParam = null;
	//private String m_repairPart = null;
	//private List<String> m_repairPartParam = null;


	public ShenQingDao()
	{
		m_db = DBUtil.getInstance();
		m_repair = "repair";
		m_repairParam = new ArrayList<String>();
		m_repairParam.add("repair_id");
		m_repairParam.add("repair_manid");
		m_repairParam.add("repair_addr");
		m_repairParam.add("repair_time");
//		m_repairPart = "repair_part";
//		m_repairPartParam = new ArrayList<String>();
//		m_repairPartParam.add("(repair_id");
//		m_repairPartParam.add("part_id");
//		m_repairPartParam.add("repair_part_num");

		
	}

	public List<ShenQingInfo> queryInfo()
	{
		String sql = "select * from "+m_repair+";";
		ResultSet res = null;
		m_db.getConnection();
		res = m_db.query(sql, null);
		List<ShenQingInfo> list = new ArrayList<ShenQingInfo>();
		
		try
		{
			while (res.next())
			{
				ShenQingInfo h = new ShenQingInfo();
				h.setId(res.getString(m_repairParam.get(0)));
				h.setManId(res.getString(m_repairParam.get(1)));
				h.setAddr(res.getString(m_repairParam.get(2)));
				h.setTime(res.getDate(m_repairParam.get(3)));
				//System.out.println("id:"+res.getString(1)+", ManId:"+res.getString(2)+", addr"+res.getString(3)+", time"+res.getString(4));
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
	public List<ShenQingInfo> queryInfoBy(int key,String args)
	{
		String sql = "select * from "+m_repair+" where "+m_repairParam.get(key)+" = ?;";
		List<Object> param = new ArrayList<Object>();
		param.add(args);
		ResultSet res = null;
		m_db.getConnection();
		res = m_db.query(sql, param);
		List<ShenQingInfo> list = new ArrayList<ShenQingInfo>();
		
		try
		{
			while (res.next())
			{
				ShenQingInfo h = new ShenQingInfo();
				h.setId(res.getString(m_repairParam.get(0)));
				h.setManId(res.getString(m_repairParam.get(1)));
				h.setAddr(res.getString(m_repairParam.get(2)));
				h.setTime(res.getDate(m_repairParam.get(3)));
				//System.out.println("id:"+res.getString(1)+", ManId:"+res.getString(2)+", addr"+res.getString(3)+", time"+res.getString(4));
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
	public ShenQingInfo queryInfoById(String args)
	{
		m_db.getConnection();
		String sql = "select * from "+m_repair+" where "+m_repair+"_id = ?;";
		List<Object> param = new ArrayList<Object>();
		param.add(args);
		ResultSet res = m_db.query(sql,param);
		ShenQingInfo h = new ShenQingInfo();
		try
		{
			while(res.next())
			{
				h.setId(res.getString(m_repairParam.get(0)));
				h.setManId(res.getString(m_repairParam.get(1)));
				h.setAddr(res.getString(m_repairParam.get(2)));
				h.setTime(res.getDate(m_repairParam.get(3)));
				//System.out.println("id:"+res.getString(1)+", ManId:"+res.getString(2)+", addr"+res.getString(3)+", time"+res.getString(4));
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
		return h;
	}

	public void addInfo(ShenQingInfo h)
	{
		m_db.getConnection();
		
		String sql = "insert into "+m_repair+" values(?,?,?,?);";
		List<Object> param = new ArrayList<Object>();
		param.add(h.getId());
		param.add(h.getManId());
		param.add(h.getAddr());
		param.add(h.getTime());
		m_db.update(sql, param);
		
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
	}

	public void delInfo(String args)
	{
		m_db.getConnection();
		String sql = "delete from "+m_repair+" where "+m_repair+"_id = ?;";
		List<Object> param = new ArrayList<Object>();
		param.add(args);
		m_db.update(sql, param);
		m_db.close();
	}

	public void updataInfo(ShenQingInfo h)
	{
		delInfo(h.getId());
		addInfo(h);
	}
	
/* test
	public static void main(String args[])
	{
			
			ShenQingInfo r = new ShenQingInfo();
			ShenQingDao rdao = new ShenQingDao();
			Date date=Date.valueOf("2016-11-01");

	//		r.setId("000d0");
	//		r.setManId("lsfg");
	//		r.setAddr("sdf");
	//		r.setTime(date);
	//		rdao.addInfo(r);
			
	//		r = rdao.queryInfoById("000d0");
	//		System.out.println("id:"+r.getId()+", manid:"+r.getManId()+", addr:"+r.getAddr()+", time:"+r.getTime());
		

	//		r.setId("000de");
	//		r.setManId("lsfddg");
	//		r.setAddr("sdsdf");
	//		r.setTime(date);
	//		rdao.updataInfo(r);
	//	
	//
			rdao.delInfo("0000");

			List<ShenQingInfo> l = rdao.queryInfo();
			for (int i = 0; i < l.size(); i++)
			{
				r = l.get(i);
				System.out.println("id:"+r.getId()+", manid:"+r.getManId()+", addr:"+r.getAddr()+", time:"+r.getTime());
			}
			System.out.println("Hello word");
	}
*/
}