package com.xj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import javassist.expr.NewArray;

import com.opensymphony.xwork2.ActionSupport;
import com.xj.dao.service.TrainResourceService;
import com.xj.typedefine.TrainResourceType;
import com.xj.vo.TrainResource;

@SuppressWarnings("serial")
public class TrainResourceAction extends ActionSupport 
{
	private TrainResource res=new TrainResource();
	private TrainResourceService resourceService=new TrainResourceService();
	private List<Object> list=new ArrayList<Object>();
	private String desc;
	private File up;
	// struts2自动填充文件�??
	private String upFileName;
	//下载文件的�??
	private String downName;
			
	public String getDownName()
	{
		return downName;
	}
	public void setDownName(String downName)
	{
		this.downName = downName;
	}
	public List<Object> getList()
	{
		return list;
	}
	public void setList(List<Object> list)
	{
		this.list = list;
	}
	
	public void upload() throws IOException
	{
		if(upFileName==null)
			return;
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		File parentFile = new File(path);
		//如果路径�?存在，创建该路径
		if(!parentFile.exists()) {
			parentFile.mkdirs();
		}
		File file = new File(parentFile, upFileName);
		FileInputStream fis = new FileInputStream(up);
		//创建type数组，长度为up中�?的长度
		byte[] data = new byte[fis.available()];
		//将up中的�?全部读�?�到data中
		fis.read(data);
		
		FileOutputStream fos = new FileOutputStream(file);
		//将data中的�?写入file中
		fos.write(data);
		
		fis.close();
		fos.close();
		res.setResource_name(upFileName);
		res.setResource_URI(up.getPath());
		res.setResource_id(UUID.randomUUID().toString());
		res.setResource_time(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		res.setResource_level("1");
		res.setResource_type(TrainResourceType.RES_VIDEO);
		res.setResource_desc(desc);
		resourceService.insertRes(res);
	}
	public InputStream getDownFile()
	{
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/" + downName);
	}
	public String download() throws Exception
	{
		
		return "down";
	}
	public String listAll() throws SQLException
	{
		
		list=resourceService.queryAllResource(TrainResourceType.RES_ALL,"");
		if(list==null)
			return "failure";
		else
			return "listRes";
	}
	public String listVideo() throws SQLException
	{
		list= resourceService.queryAllResource(TrainResourceType.RES_VIDEO,"");
		if(list==null)
			return "failure";
		else
			return "listRes";
	}
	public String listDoc() throws SQLException
	{
		list= resourceService.queryAllResource(TrainResourceType.RES_DOC,"");
		if(list==null)
			return "failure";
		else
			return "listRes";
	}
	public String searchResByName(String searchName) throws SQLException
	{
		return null;

	}
	public TrainResource getRes()
	{
		return res;
	}
	public void setRes(TrainResource res)
	{
		this.res = res;
	}
	public TrainResourceService getResourceService()
	{
		return resourceService;
	}
	public void setResourceService(TrainResourceService resourceService)
	{
		this.resourceService = resourceService;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public File getUp()
	{
		return up;
	}
	public void setUp(File up)
	{
		this.up = up;
	}
	public String getUpFileName()
	{
		return upFileName;
	}
	public void setUpFileName(String upFileName)
	{
		this.upFileName = upFileName;
	}
	
}
