package com.xj.dao.service;

import java.util.List;

//import ResourceDao;
//import ResourceInfo;
import com.xj.dao.impl.ResourceDao;
import com.xj.vo.ResourceInfo;

public class ResourceService 
{
	private ResourceDao m_RDao = new ResourceDao();
	public List<ResourceInfo> queryInfo()
	{
		return m_RDao.queryInfo();
	}

	public ResourceInfo queryInfoById(String args)
	{
		return m_RDao.queryInfoById(args);
	}

	public void addInfo(ResourceInfo h)
	{
		m_RDao.addInfo(h);
	}

	public void delInfo(String args)
	{
		m_RDao.delInfo(args);
	}

	public void updataInfo(ResourceInfo h)
	{
		m_RDao.updataInfo(h);
	}
/*
	public static void main(String args[])
	{
		
		ResourceInfo r = new ResourceInfo();
		ResourceService rdao = new ResourceService();
		
//		r.setId("0123");
//		r.setName("lsfg");
//		r.setNum(109);
//		rdao.addInfo(r);
		
//		r = rdao.queryInfoById("0123");
//		System.out.println("id:"+r.getId()+", name:"+r.getName()+", amount:"+r.getNum());
		

//		r.setId("0123");
//		r.setName("xinxin");
//		r.setNum(108);
//		rdao.updataInfo(r);
	

		//rdao.delInfo("0123");

		List<ResourceInfo> l = rdao.queryInfo();
		for (int i = 0; i < l.size(); i++)
		{
			r = l.get(i);
			System.out.println("id:"+r.getId()+", name:"+r.getName()+", amount:"+r.getNum());
		}

		System.out.println("Hello word");
	}
	*/
}
