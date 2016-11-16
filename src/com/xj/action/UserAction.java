package com.xj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.xj.dao.service.UserService;
import com.xj.vo.User;

public class UserAction {
	private UserService userSer = new UserService();
	private List<User> list = new ArrayList<User>();
	private User u = new User();
	
	
	//验证登录
		public String login(){
			if(userSer.valuser(u)){
				//在session中保存登录成功的用户名
				Map<String,Object> session = ActionContext.getContext().getSession();
				session.put("sess_user", u.getUser_Name());
				
				
				return "login_success";
			}else{
				return "login_false";
			}
		}
	//logout
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("sess_user");
		return "login_success";
	}
	public UserService getUserSer() {
		return userSer;
	}
	public void setUserSer(UserService userSer) {
		this.userSer = userSer;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
}
