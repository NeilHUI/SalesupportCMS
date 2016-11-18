package com.xj.vo;

public class FeedBack {
	private String P_ID;
	private String Order_ID;
	private double FB_Score;
	private String FB_Comment;
	private String FB_ID;
	
	public String getP_ID() {
		return P_ID;
	}
	public void setP_ID(String P_ID) {
		this.P_ID = P_ID;
	}
	public String getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}
	public double getFB_Score() {
		return FB_Score;
	}
	public void setFB_Score(double FB_Score) {
		this.FB_Score = FB_Score;
	}
	public String getFB_Comment() {
		return FB_Comment;
	}
	public void setFB_Comment(String fB_Comment) {
		FB_Comment = fB_Comment;
	}
	public String getFB_ID() {
		return FB_ID;
	}
	public void setFB_ID(String fB_ID) {
		FB_ID = fB_ID;
	}
	
}
