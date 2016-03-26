package com.nebny.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
public class LoginBean {

	private String username1;
	private String password1;

	public LoginBean() {

	}

	public void signin() throws ClassNotFoundException, SQLException, IOException {

		ResultSet u = ConnectionMySQL.ReturnResult("SELECT iduser from user WHERE username='" + username1 + "'");
		ResultSet p = ConnectionMySQL.ReturnResult("SELECT iduser from user WHERE password='" + password1 + "'");
		u.next();
		p.next();
		String s1 = u.getString(1);
		String s2 = p.getString(1);
		int uid = Integer.parseInt(s1);
		int pid = Integer.parseInt(s2);
		if (uid == pid) {
			// System.out.print("correct"+uid);
			// }

			// return "index.xhtml";
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			context.redirect("index.xhtml");
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect("index.xhtml");
	}

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

}

/*
 * private String userName; private String password;
 * 
 * public LoginBean() { userName = "username"; password = "password"; }
 * 
 * public void foo() {
 * 
 * System.out.println(userName);
 * FacesContext.getCurrentInstance().addMessage(null, new
 * FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
 * 
 * }
 * 
 * public String getUserName() { return userName; }
 * 
 * public void setUserName(String userName) { this.userName = userName; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 */
