package com.xj.dao.service;

import java.sql.SQLException;
import java.util.List;

import com.xj.dao.ITrainResourceDao;
import com.xj.dao.impl.TrainResourceDao;
import com.xj.vo.TrainResource;
import com.xj.vo.Student;

public class TrainResourceService 
{

	private TrainResourceDao resourceDao=new TrainResourceDao();
	public List<Object> queryAllResource(int resourceType,String searchContent)
			throws SQLException
	{
		
		return resourceDao.queryAllResource(resourceType,searchContent);
	}

	public Student queryResourceID(String id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void insertRes(TrainResource res)
	{
		resourceDao.insertRes(res);
	}

	public void delRes(String id)
	{
		// TODO Auto-generated method stub
		
	}

	public void updateRes(Student s)
	{
		// TODO Auto-generated method stub
		
	}

	public void insertResVideo()
	{
		// TODO Auto-generated method stub
		
	}

	public void intertResDoc()
	{
		// TODO Auto-generated method stub
		
	}
	public List<Object> getResByName(int resourceType,String name)
	{
		try
		{
			return resourceDao.getResByName(resourceType, name);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
