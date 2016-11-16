package com.xj.dao.service;

import java.util.List;

import com.xj.dao.impl.FeedBackDao;
import com.xj.vo.FeedBack;

public class FeedBackService {

private FeedBackDao FBdao=new FeedBackDao();
	
	public List<FeedBack> QueryAllFeedBack(){
		return FBdao.QueryAllFeedBack();
	}
	
	public FeedBack QueryFeedBack(String id){
		return FBdao.QueryFeedBackByID(id);
	}
	
	public void InsertFeedBack(FeedBack a){
		FBdao.InsertFeedBack(a);
	}
	
	public void DeleteFeedBack(String id){
		FBdao.DeleteFeedBack(id);
	}
	
	public void UpdateFeedBack(FeedBack a){
		FBdao.UpdateFeedBack(a);
	}
}
