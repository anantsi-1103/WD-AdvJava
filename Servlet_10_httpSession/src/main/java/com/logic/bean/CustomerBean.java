package com.logic.bean;

import java.io.Serializable;


public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String uname, pass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerBean [id=" + id + ", uname=" + uname + ", pass=" + pass + "]";
	}

}
