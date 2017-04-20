package edu.poly.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Users")
public class User {
	@Id
	@Size(min =1, max = 30)
	@Column(name="Username")
	String username;
	
	@NotNull
	@Size(min =1, max = 30)
	@Column(name="Password")
	String password;
	
	@NotNull
	@Size(min= 1, max = 50)
	@Column(name="Fullname")
	private String fullname;
	
	public User() {
		super();
	}

	public User(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
