package com.xj.dao.service;

import java.util.List;

//import ShenQingDao;
//import ShenQingInfo;
import com.xj.dao.impl.ShenQingDao;
import com.xj.vo.ShenQingInfo;

public class ShenQingService 
{
	private ShenQingDao m_SDao = new ShenQingDao();
	
	
	public List<ShenQingInfo> queryInfo()
	{
		return m_SDao.queryInfo();
	}

	public ShenQingInfo queryInfoById(String args)
	{
		return m_SDao.queryInfoById(args);
	}
	public List<ShenQingInfo> queryInfoBy(int key,String args)
	{
		return m_SDao.queryInfoBy(key,args);
	}

	public void addInfo(ShenQingInfo h)
	{
		m_SDao.addInfo(h);
	}

	public void delInfo(String args)
	{
		m_SDao.delInfo(args);
	}

	public void updataInfo(ShenQingInfo h)
	{
		m_SDao.updataInfo(h);
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
