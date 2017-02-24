package com.accenture.aflac.lms.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 作用：用来存储于用户相关的信息，与数据库中的用户表（lms_user）相对应
 */
public class User extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String eid;
    private String realName;
    private String password;
    private String role;
    private String tel;
    private Integer borrowedCount;       //用户的书籍借阅数量
    private String projectName;
    private Integer borrowCountLimit;    //最大可借阅书籍数量
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getBorrowedCount() {
		return borrowedCount;
	}
	public void setBorrowedCount(Integer borrowedCount) {
		this.borrowedCount = borrowedCount;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getBorrowCountLimit() {
		return borrowCountLimit;
	}
	public void setBorrowCountLimit(Integer borrowCountLimit) {
		this.borrowCountLimit = borrowCountLimit;
	}

}
