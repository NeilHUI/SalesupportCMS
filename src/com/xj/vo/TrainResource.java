package com.xj.vo;

import java.sql.Date;

public class TrainResource
{
	private String resource_id;
	private String resource_name;
	private String resource_URI;
	private int resource_type;
	private String resource_level;
	private Date resource_time;
	private String resource_desc;
	public String getResource_desc()
	{
		return resource_desc;
	}
	public void setResource_desc(String resource_desc)
	{
		this.resource_desc = resource_desc;
	}
	public String getResource_id()
	{
		return resource_id;
	}
	public void setResource_id(String resource_id)
	{
		this.resource_id = resource_id;
	}
	public String getResource_name()
	{
		return resource_name;
	}
	public void setResource_name(String resource_name)
	{
		this.resource_name = resource_name;
	}
	public String getResource_URI()
	{
		return resource_URI;
	}
	public void setResource_URI(String resource_URI)
	{
		this.resource_URI = resource_URI;
	}
	public int getResource_type()
	{
		return resource_type;
	}
	public void setResource_type(int resource_type)
	{
		this.resource_type = resource_type;
	}
	public String getResource_level()
	{
		return resource_level;
	}
	public void setResource_level(String resource_level)
	{
		this.resource_level = resource_level;
	}
	public Date getResource_time()
	{
		return resource_time;
	}
	public void setResource_time(Date resource_time)
	{
		this.resource_time = resource_time;
	}
	
			
}
