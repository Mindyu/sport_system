package com.mindyu.sport_system.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="info")
public class Info {

	@Id
	@GeneratedValue
	private Integer id;//
	private Integer userId;//
	private String sex;
	private String avator;//
	private String email;//
	private Double height;//
	private Integer stepPlan;//
	private Double weight;//
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;//
	private String phone;//
	private String address;//
	private String extra;//
	private String intro;//
	private Integer status;//
	private Date createdAt;//
	private Date updatedAt;//

	
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

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}

	public Integer getStepPlan() {		
		return stepPlan;
	}
	public void setStepPlan(Integer stepPlan) {
		this.stepPlan = stepPlan;
	}

	public Double getWeight() {		
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public java.util.Date getBirthday() {		
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {		
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {		
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getExtra() {		
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getIntro() {		
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Info{" +
				"id=" + id +
				", userId=" + userId +
				", sex=" + sex +
				", height=" + height +
				", stepPlan=" + stepPlan +
				", weight=" + weight +
				", birthday=" + birthday +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", extra='" + extra + '\'' +
				", intro='" + intro + '\'' +
				", status=" + status +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}
