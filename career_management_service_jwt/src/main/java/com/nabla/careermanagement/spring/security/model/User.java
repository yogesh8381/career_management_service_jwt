package com.nabla.careermanagement.spring.security.model;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private String rol;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public User(Long id, String username, String password, String email, String rol) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.rol = rol;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    

    //more properties as your project requirements


}
