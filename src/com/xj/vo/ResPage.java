package com.xj.vo;

public class ResPage
{
	private int totalRecord;//总的记录数
	private int onePageNum=10;//一页的记录数
	private int currentPage=1;//当前的页数
	private int totalPage;//总的页数
	public int getTotalRecord()
	{
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}
	public int getOnePageNum()
	{
		return onePageNum;
	}
	public void setOnePageNum(int onePageNum)
	{
		this.onePageNum = onePageNum;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	
	
}
