package com.accenture.aflac.lms.dao.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * 作用：BaseEntity用于存放所有实体的共通属性
 *
 */
public class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//数据的创建人，此处存放的用户的eid
	private String createUser;
	
	//数据的创建时间
	private Date createDate;
	
	//数据的更新人，此处存放的用户的eid
	private String updateUser;
	
	//数据的更新时间
	private Date updateDate;
	
	//删除状态，即程序不做物理删除，当状态值为1时认为数据已删除（数据默认状态值为0）
	private int deleteStatus;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		//一条记录创建应只有一次，一旦记录被创建则不允许修改
		if(this.createUser!=null){
			return;
		}
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	

}
