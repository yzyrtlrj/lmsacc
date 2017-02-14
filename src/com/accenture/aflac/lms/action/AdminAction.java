package com.accenture.aflac.lms.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.accenture.aflac.lms.dao.entity.Admin;
import com.accenture.aflac.lms.service.AdminService;
import com.accenture.aflac.lms.util.MD5Util;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	//模型驱动使用的对象
	private Admin admin=new Admin();

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	
	//注入AdminService
	@Autowired
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//管理员登录的方法
	public String login(){
		//加密登录密码再与数据库中的值进行比较
		admin.setPassword(MD5Util.encoderToMD5(admin.getPassword()));
		admin=adminService.login(admin);
		if(admin==null){
			//登录失败
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("admin", admin);
			return "loginSuccess";
		}
	}
	
	

}
