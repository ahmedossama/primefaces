package com.nebny.beans;

import java.sql.SQLException;
public class test {
	int ID=0;
	public test(){
		
	}

	public void SignUp(String first_name,String username, String password) throws ClassNotFoundException, SQLException{
		ID++;
		ConnectionMySQL.SetResult("INSER INTO user VALUES("+ID+","+first_name+","+username+","+password+")");
		
		
	}
	
}
