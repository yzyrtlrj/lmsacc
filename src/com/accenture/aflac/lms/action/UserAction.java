package com.accenture.aflac.lms.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.accenture.aflac.lms.common.PaginationUtil;
import com.accenture.aflac.lms.dao.entity.Record;
import com.accenture.aflac.lms.dao.entity.User;
import com.accenture.aflac.lms.dao.vo.Pagination;
import com.accenture.aflac.lms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements SessionAware,RequestAware{

	private Map<String, Object> session;
	
	private Map<String, Object> request;
	
	private UserService userService;
	
	private User user;
	
	private Record record;
	
	private Pagination pagination=new Pagination();

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	//用户登录
	public String login(){
		//如果用户或用户eid为空，则直接返回failure
		if(user==null || user.getEid()==null)
			return "failure";
		User user2=userService.validateUserLogin(user);
		if(user2==null){
			return "failure";
		}
		session.put("userinfo", user2);
		return SUCCESS;
	}
	
	//用户注销登录
	public String logoff(){
		session.remove("userinfo");
		return SUCCESS;
	}
	
	//查看用户详情
	public String userDetail(){
		user=userService.findById(user.getId());
		return SUCCESS;
	}
	
	//列出所有满足指定条件的用户，考虑分页显示
	public String userList(){
		pagination.setCount(userService.countRows());
		PaginationUtil.execute(pagination);
		List<User> allUsers = userService.findAll(pagination);
		request.put("userList", allUsers);
		return SUCCESS;
	}
	
	//忘记密码
	public String forgetPassword(){
		return SUCCESS;
	}
	
	public String addUserInput(){
		return SUCCESS;
	}
	
	//添加用戶
	public String addUser(){
		user.setCreateDate(new Date((new java.util.Date().getTime())));
		user.setCreateUser(user.getEid());
		int i = userService.add(user);
		if (i>0) {
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	//刪除用戶
	public String deleteUser(){
		user=userService.findById(user.getId());
		int i = userService.delete(user);
		if (i>0) {
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String updateUserInput(){
		user=userService.findById(user.getId());
		return SUCCESS;
	}
	
	//修改用戶
	public String updateUser(){	
		int i = userService.update(user);
		if (i>0) {
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//按圖書索引號查找用戶
    public String selectUserByBookIndex(){
		List<User> users = userService.findUserByBookIndexNum(record);
		request.put("users", users);
		return SUCCESS;
	}

	
	

}
