package com.xj.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.dao.IFeedBack;
import com.xj.util.DBUtil;
import com.xj.vo.FeedBack;

public class FeedBackDao implements IFeedBack{

	private DBUtil util=DBUtil.getInstance();
	private String sql=null;
	private ResultSet rs=null;
	
	@Override
	public List<FeedBack> QueryAllFeedBack() {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from FeedBack";
		rs=util.query(sql, null);
		List<FeedBack> list=new ArrayList<FeedBack>();
		try {
			while(rs.next()){
				FeedBack fd=new FeedBack();
				fd.setFB_ID(rs.getString("fB_ID"));
				fd.setP_ID(rs.getString("p_ID"));
				fd.setOrder_ID(rs.getString("order_ID"));
				fd.setFB_Score(rs.getDouble("fB_Score"));
				fd.setFB_Comment(rs.getString("fB_Comment"));
				list.add(fd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return list;
	}

	@Override
	public FeedBack QueryFeedBackByID(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="select * from FeedBack where FB_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		rs=util.query(sql, params);
		FeedBack fd=new FeedBack();
		try {
			while(rs.next()){				
				fd.setP_ID(rs.getString("p_ID"));
				fd.setOrder_ID(rs.getString("order_ID"));
				fd.setFB_Score(rs.getDouble("fB_Score"));
				fd.setFB_Comment(rs.getString("fB_Comment"));
				fd.setFB_ID(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return fd;
	}

	@Override
	public void InsertFeedBack(FeedBack fb) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="insert into FeedBack values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(fb.getFB_ID());
		params.add(fb.getP_ID());
		params.add(fb.getOrder_ID());
		params.add(fb.getFB_Score());
		params.add(fb.getFB_Comment());
		util.update(sql, params);
		util.close();
	}

	@Override
	public void DeleteFeedBack(String id) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="delete from FeedBack where FB_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		util.update(sql, params);
		util.close();
	}

	@Override
	public void UpdateFeedBack(FeedBack fb) {
		// TODO Auto-generated method stub
		util.getConnection();
		sql="update FeedBack set P_ID=?,Order_ID=?,FB_Score=?,FB_Comment=? where FB_ID=?";
		List<Object> params=new ArrayList<Object>();
		params.add(fb.getP_ID());
		params.add(fb.getOrder_ID());
		params.add(fb.getFB_Score());
		params.add(fb.getFB_Comment());
		params.add(fb.getFB_ID());
		util.update(sql, params);
		util.close();
	}

}
