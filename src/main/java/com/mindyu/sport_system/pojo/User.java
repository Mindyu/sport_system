package com.mindyu.sport_system.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//
	private String userName;
	private String password;//
	private String salt;//
	private String avator;//
	private String email;//
	private Integer status;//
	private Integer createdAt;//
	private Integer updatedAt;//

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {		
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {		
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
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

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Integer createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Integer updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", Salt='" + salt + '\'' +
				", avator='" + avator + '\'' +
				", email='" + email + '\'' +
				", status=" + status +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}
