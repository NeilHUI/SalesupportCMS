package com.xj.vo;

import java.sql.Date;
public class ShenQingInfo
{
	private String id;
	//private Timestamp time;
	private Date time;
	private String manId;
	private String addr;

	//private List<ResourceInfo> data;
	
	public void setId(String id)
	{
		this.id = id;
	}
	public String getId()
	{
		return this.id;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
	public Date getTime()
	{
		return this.time;
	}
	public void setManId(String manId)
	{
		this.manId = manId;
	}
	public String getManId()
	{
		return this.manId;
	}
	public void setAddr(String addr)
	{
		this.addr = addr;
	}
	public String getAddr()
	{
		return this.addr;
	}
/*
	public List<ResourceInfo> getData()
	{
		return this.data;
	}
*/
}


