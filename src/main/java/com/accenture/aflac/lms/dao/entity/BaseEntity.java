package com.accenture.aflac.lms.dao.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 作用：BaseEntity用于存放所有实体的共通属性
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;
	//数据的创建人，此处存放的用户的eid
	protected String createUser;
	//数据的创建时间
	protected Date createTime;
	//数据的更新人，此处存放的用户的eid
	protected String updateUser;
	//数据的更新时间
	protected Date updateTime;
	//删除状态，即程序不做物理删除，当状态值为1时认为数据已删除（数据默认状态值为0）
	protected Integer deleteStatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	

	
	
	

}
