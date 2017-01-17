package com.accenture.aflac.lms.dao.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import com.accenture.aflac.lms.common.MD5Util;

import sun.misc.BASE64Encoder;

/**
 * 
 * 作用：用来存储于用户相关的信息，与数据库中的用户表（lms_user）相对应
 *
 */
public class User extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//主键
    private Long id;
	
	//即用户EID,作为用户登录的用户名，要求唯一
	private String eid;
    
	//用户真实姓名
    private String realName;
    
    //登录密码
    private String password;
    
    //电子邮箱，考虑到可能使用非公司邮箱账号
    private String email;
    
    //用户的角色
    private String role;
    
    //电话号码
    private String tel;
    
    //性别
    private String sex;
    
    //用户的书籍借阅数量
    private int borrowedCount;
    
    //项目名
    private String projectName;
    
    //最大可借阅书籍数量
    private int borrowCountLimit;
    
    //备注信息
  	private String remark;
  	
    //用户与记录是一对多的关系，一个人可以有多条借阅记录
  	private Set<Record> records=new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
			this.password =password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getBorrowedCount() {
		return borrowedCount;
	}

	public void setBorrowedCount(int borrowedCount) {
		this.borrowedCount = borrowedCount;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getBorrowCountLimit() {
		return borrowCountLimit;
	}

	public void setBorrowCountLimit(int borrowCountLimit) {
		this.borrowCountLimit = borrowCountLimit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

}
