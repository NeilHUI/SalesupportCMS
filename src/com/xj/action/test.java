package com.xj.action;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.xj.util.DBUtil;

public class test {
	private static DBUtil util=DBUtil.getInstance();
	private static String sql=null;
	private ResultSet rs=null;
	public static void main(String args[]){
		util.getConnection();
		String a = "Repair_EndT";
		sql="update RepairTable set "+a+"=?  where Repair_ID=?";
		List<Object> params=new ArrayList<Object>();
		//datetime转换(不通用)
		
		Timestamp d = new Timestamp(System.currentTimeMillis());
		params.add(d);
		
	
		
		params.add("e44ae996-12b0-4fb5-");

		
		util.update(sql, params);
		util.close();
		
		
	}
}
