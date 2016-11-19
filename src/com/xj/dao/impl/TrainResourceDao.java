package com.xj.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.ResourceSet;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.xj.dao.ITrainResourceDao;
import com.xj.util.DBUtil;
import com.xj.vo.TrainResource;
import com.xj.vo.Student;

public class TrainResourceDao implements ITrainResourceDao
{

	private String sql;
	private DBUtil dbUtil;
	private ResultSet rst;
	public TrainResourceDao()
	{
		dbUtil=DBUtil.getInstance();
	}
	@Override
	public List<Object> queryAllResource(int resourceType,String searchContent) throws SQLException
	{
		dbUtil.getConnection();
		sql="select * from resource_table where resource_type="+resourceType+" and resource_name like '%"+searchContent+"%'";
		rst=dbUtil.query(sql, null);
		List<Object> list=new ArrayList<Object>();
		if(rst!=null)
		{
			while(rst.next())
			{
				TrainResource res=new TrainResource();
				res.setResource_id(rst.getString("resource_id"));
				res.setResource_name(rst.getString("resource_name"));
				res.setResource_URI(rst.getString("resource_URI"));
				res.setResource_time(Date.valueOf(rst.getString("resource_time")));
				res.setResource_desc(rst.getString("resource_desc"));
				list.add(res);
			}
		}
		dbUtil.close();
		return list;
		
	}
	public List<Object> getResByName(int resourceType,String name) throws SQLException
	{
		dbUtil.getConnection();
		sql="select * from resource_table where resource_type="+resourceType+"resource_name="+name+"";
		rst=dbUtil.query(sql, null);
		List<Object> list=new ArrayList<Object>();
		if(rst!=null)
		{
			while(rst.next())
			{
				TrainResource res=new TrainResource();
				res.setResource_id(rst.getString("resource_id"));
				res.setResource_name(rst.getString("resource_name"));
				res.setResource_URI(rst.getString("resource_URI"));
				res.setResource_time(Date.valueOf(rst.getString("resource_time")));
				res.setResource_desc(rst.getString("resource_desc"));
				list.add(res);
			}
		}
		dbUtil.close();
		return list;
		
	}

	@Override
	public Student queryResourceID(String id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRes(TrainResource res)
	{
		dbUtil.getConnection();
												//ID NAME URI TYPE LEVEL TIME DESC
		String sql="insert into resource_table values(?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		res.getResource_level();
		params.add(res.getResource_id());
		params.add(res.getResource_name());
		params.add(res.getResource_URI());
		params.add(res.getResource_type());
		params.add(res.getResource_level());
		params.add(res.getResource_time());
		params.add(res.getResource_desc());
		dbUtil.update(sql, params);
		dbUtil.close();
	}

	@Override
	public void delRes(String id)
	{
		// TODO Auto-generated method stub
		
	}

	public void updateRes(TrainResource res)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertResVideo()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intertResDoc()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Object> queryAllResource(int resourceType) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
