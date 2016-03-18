package com.nebny.beans;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.sql.* ;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "loginBean", eager=true)
@RequestScoped
public class LoginBean implements Serializable{
	
	
	private static String username1;
	private static String password1;
	
public LoginBean(){
	
}

public static boolean exists() throws ClassNotFoundException, SQLException{
	ResultSet u=ConnectionMySQL.ReturnResult("SELECT iduser from user WHERE username='"+username1+"'");
	ResultSet p=ConnectionMySQL.ReturnResult("SELECT iduser from user WHERE password='"+password1+"'");
	if (!u.next()){
		//System.out.print("false");
		return false;
	}
	if(!p.next()){
		//System.out.print("false");
		return false;
	}
	//System.out.print("true");
		return true;
	
	
}		

		public String signin() throws ClassNotFoundException, SQLException, IOException{
			
			//RequestContext context = RequestContext.getCurrentInstance();
	        FacesMessage message = null;
	        if(exists()){
	        	ResultSet u=ConnectionMySQL.ReturnResult("SELECT iduser from user WHERE username='"+username1+"'");
				ResultSet p=ConnectionMySQL.ReturnResult("SELECT iduser from user WHERE password='"+password1+"'");
				u.next();
				p.next();
				String s1 = u.getString(1);
				String s2 = p.getString(1);
			    int uid = Integer.parseInt(s1);
			    int pid = Integer.parseInt(s2);
				if(uid==pid){
				
				return "index";
	        }
	        }
			
			
			//	ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				//context.redirect("index.xhtml")
				
				 
		         message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		         FacesContext.getCurrentInstance().addMessage(null, message);

		         return "signin";
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
	
	
	
	
	
	
	
	

	
	
	
	/*private String userName;
	private String password;

	public LoginBean() {
		userName = "username";
		password = "password";
	}

	public void foo() {

		System.out.println(userName);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));

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
	}*/


