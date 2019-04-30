package com.mindyu.sport_system.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="stepCount")
public class Count {

	@Id
	@GeneratedValue
	private Integer id;//
	private Integer userId;//
	private java.util.Date date;//
	private Integer stepCount;//
	private Integer status;//

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {		
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public Integer getStepCount() {		
		return stepCount;
	}
	public void setStepCount(Integer stepCount) {
		this.stepCount = stepCount;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Count{" +
				"id=" + id +
				", userId=" + userId +
				", date=" + date +
				", stepCount=" + stepCount +
				", status=" + status +
				'}';
	}
}
