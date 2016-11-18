package com.xj.dao;

import java.sql.SQLException;
import java.util.List;

import com.xj.vo.TrainResource;
import com.xj.vo.Student;

public interface ITrainResourceDao
{
	
	public List<Object> queryAllResource(int resourceType) throws SQLException;
	
	public Student queryResourceID(String id);
	
	public void insertRes(TrainResource res);
	
	public void delRes(String id);
	
	public void updateRes(TrainResource s);
	public List<Object> getResByName(int resourceType,String name) throws SQLException;
	
	public void insertResVideo();
	
	public void intertResDoc();

	List<Object> queryAllResource(int resourceType, String searchContent)
			throws SQLException;

}
