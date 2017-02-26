package com.accenture.aflac.lms.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.accenture.aflac.lms.entity.User;
import com.accenture.aflac.lms.service.UserService;
import com.accenture.aflac.lms.util.MD5Util;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动使用的对象
	private User user=new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//注入UserService
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//跳转到登录用户界面
	public String loginPage(){
		return "loginPage";
	}
	
	//用户登录的方法
	public String login(){
		//对用户的密码进行加密与数据库比较
		user.setPassword(MD5Util.encoderToMD5(user.getPassword()));
		//调用业务层用户登录的方法
		user=userService.login(user);
		if(user!=null){
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("userinfo", user);
			return "loginSuccess";
		}else{
			//登录失败
			return LOGIN;
		}
		
	}
	
	//用户注销
	public String logout(){
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	

}
