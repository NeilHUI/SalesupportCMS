package com.xj.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.service.TrainResourceService;
import com.xj.typedefine.TrainResourceType;
import com.xj.vo.ResPage;

public class ResPageAction
{
	private ResPage resPage=new ResPage();
	private TrainResourceService resourceService=new TrainResourceService();
	private List<Object> list=new ArrayList<Object>();
	private int resource_type;
	private String searchContent;
	public int getResource_type()
	{
		return resource_type;
	}
	
	public String getSearchContent()
	{
		return searchContent;
	}

	public void setSearchContent(String searchContent)
	{
		this.searchContent = searchContent;
	}

	public void setResource_type(int resource_type)
	{
		this.resource_type = resource_type;
	}
	public String listRes() throws SQLException
	{
		if(searchContent==null)
		{
			searchContent="";
		}
		List<Object> listTemp=resourceService.queryAllResource(resource_type,searchContent);
		if(listTemp.size()==0)
			return "failure";
		//resPage.setOnePageNum(2);
		resPage.setTotalRecord(listTemp.size());
		int mod=listTemp.size()%resPage.getOnePageNum();
		int div=listTemp.size()/resPage.getOnePageNum();
		int totalPage=mod==0?div:div+1;
		resPage.setTotalPage(totalPage);
		if(resPage.getCurrentPage()==0)
		{
			resPage.setCurrentPage(1);
		}
		int fromIndex;
		int toIndex;
		if(resPage.getCurrentPage()>=totalPage)
		{
			resPage.setCurrentPage(totalPage);
			if(mod!=0)
			{
				fromIndex=(totalPage-1)*resPage.getOnePageNum();
				toIndex=fromIndex+mod;
			}
			else
			{
				fromIndex=(totalPage-1)*resPage.getOnePageNum();
				toIndex=totalPage*resPage.getOnePageNum();
			}
		}
		else
		{
			fromIndex=(resPage.getCurrentPage()-1)*resPage.getOnePageNum();
			toIndex=(resPage.getCurrentPage())*resPage.getOnePageNum();
		}
	
		list=listTemp.subList(fromIndex, toIndex);
		if(resource_type==1)
			return "listVideoRes";
		if(resource_type==2)
			return "listDocRes";
		return "failure";
	}
	public List<Object> getList()
	{
		return list;
	}
	public void setList(List<Object> list)
	{
		this.list = list;
	}
	public ResPage getResPage()
	{
		return resPage;
	}

	public void setResPage(ResPage resPage)
	{
		this.resPage = resPage;
	}
	
}
