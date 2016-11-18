package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.ShenQingPartDao;
import com.xj.vo.ShenQingPartInfo;

public class ShenQingPartService {
	private ShenQingPartDao m_SDao = new ShenQingPartDao();
	
	public void addInfo(ShenQingPartInfo sqp)
	{
		m_SDao.addInfo(sqp);
	}
	
	public List<ShenQingPartInfo> queryInfo()
	{
		return m_SDao.queryInfo();
	}
	
	public List<ShenQingPartInfo> queryInfoByRepairId(String args)
	{
		return m_SDao.queryInfoByRepairId(args);
	}
	
	public List<ShenQingPartInfo> queryInfoBy(int key,String args)
	{
		return m_SDao.queryInfoBy(key,args);
	}
}
