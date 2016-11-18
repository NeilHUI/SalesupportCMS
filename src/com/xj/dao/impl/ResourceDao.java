package com.xj.dao.impl;

import java.sql.ResultSet;
import java.lang.Exception;
import java.util.List;
import java.util.ArrayList;
//import DBUtil;
//import ResourceInfo;

import com.xj.util.DBUtil;
import com.xj.vo.ResourceInfo;


public class ResourceDao
{
	private DBUtil m_db = null;
	private String m_tableName = null;
	private List<String> m_paramList = null;
	
	public ResourceDao()
	{
		m_db = DBUtil.getInstance();
		m_tableName = "part";
		m_paramList = new ArrayList<String>();
		m_paramList.add("part_id");
		m_paramList.add("part_name");
		m_paramList.add("part_amount");
	}
	
	public List<ResourceInfo> queryInfo()
	{
		
		String sql = "select * from "+m_tableName+";";
		ResultSet res = null;
		m_db.getConnection();
		res = m_db.query(sql, null);
		
		List<ResourceInfo> list = new ArrayList<ResourceInfo>();
		
		list.clear();
		try
		{
			while (res.next())
			{
				ResourceInfo h = new ResourceInfo();
				h.setId(res.getString(m_paramList.get(0)));
				h.setName(res.getString(m_paramList.get(1)));
				h.setNum(res.getInt(m_paramList.get(2)));
				System.out.println(">>>>id:"+h.getId()+", name:"+h.getName()+", amount:"+h.getNum());
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
		/*
		for (int i = 0; i < list.size(); i++)
		{
			ResourceInfo h = new ResourceInfo();
			h = list.get(i);
			System.out.println("*****id:"+h.getId()+", name:"+h.getName()+", amount:"+h.getNum());
		}
		*/
		return list;
	}

	public ResourceInfo queryInfoById(String args)
	{
		m_db.getConnection();
		String sql = "select * from "+m_tableName+" where "+m_tableName+"_id = ?;";
		List<Object> param = new ArrayList<Object>();
		param.add(args);
		ResultSet res = m_db.query(sql,param);
		ResourceInfo h = new ResourceInfo();
		try
		{
			while (res.next())
			{
				//System.out.println("id:"+res.getString(1)+", name:"+res.getString(2));
				h.setId(res.getString(m_paramList.get(0)));
				h.setName(res.getString(m_paramList.get(1)));
				h.setNum(res.getInt(m_paramList.get(2)));
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

	public void addInfo(ResourceInfo h)
	{
		m_db.getConnection();
		System.out.println("getConnection OK");

		String sql = "insert into "+m_tableName+" values(?,?,?);";
		List<Object> param = new ArrayList<Object>();
		param.add(h.getId());
		param.add(h.getName());
		param.add(h.getNum());
		m_db.update(sql, param);
		System.out.println("update OK");

		m_db.close();
		System.out.println("close OK");
	}

	public void delInfo(String args)
	{
		m_db.getConnection();
		String sql = "delete from "+m_tableName+" where "+m_tableName+"_id = ?;";
		List<Object> param = new ArrayList<Object>();
		param.add(args);
		m_db.update(sql, param);
		m_db.close();
	}

	public void updataInfo(ResourceInfo h)
	{
		/*
		m_db.getConnection();
		String sql = "update "+m_tableName+"";
		List<Object> param = new ArrayList<Object>();
		param.add(h.getId());
		param.add(h.getName());
		param.add(h.getNum());
		m_db.update(sql, null);
		m_db.close();
		*/
		delInfo(h.getId());
		addInfo(h);
	}
/* test
	public static void main(String args[])
	{
		
		ResourceInfo r = new ResourceInfo();
		ResourceDao rdao = new ResourceDao();
		
		r.setId("0000");
		r.setName("lsfg");
		r.setNum(109);
		rdao.addInfo(r);
		
		//r = rdao.queryInfoById("0123");
		//System.out.println("id:"+r.getId()+", name:"+r.getName()+", amount:"+r.getNum());
		

		//r.setId("0123");
		//r.setName("xinxin");
		//r.setNum(108);
		//rdao.updataInfo(r);
	

		//rdao.delInfo("01233");

		List<ResourceInfo> l = rdao.queryInfo();
		for (int i = 0; i < l.size(); i++)
		{
			r = l.get(i);
			System.out.println(" "+i+" id:"+r.getId()+", name:"+r.getName()+", amount:"+r.getNum());
		}
		System.out.println("Hello word");
	}
*/
}