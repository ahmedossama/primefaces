package com.nebny.beans;

import java.sql.* ;
public class ConnectionMySQL {

	public static ResultSet ReturnResult(String query) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/new_schema","root","hassnaasalem");
		PreparedStatement statement = conn.prepareStatement(query);
		ResultSet result= statement.executeQuery();
		//while(result.next()){
			//System.out.println("  "+result.getString(1)+ "  " +result.getString(2));
		//}
		return result;
		
	}
	public static void SetResult(String query) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/new_schema","root","hassnaasalem");
		PreparedStatement statement = conn.prepareStatement(query);
		statement.executeUpdate();
		//while(result.next()){
			//System.out.println("  "+result.getString(1)+ "  " +result.getString(2));
		//}
		
	}
	
	public static void SignUp(String first_name,String username, String password) throws ClassNotFoundException, SQLException{
		
		
		SetResult("INSERT INTO user(first_name,username,password) VALUES('"+first_name+"','"+username+"','"+password+"');");
		
	
		}
	
	public static int signin(String username, String password) throws ClassNotFoundException, SQLException{
		
		ResultSet u=ReturnResult("SELECT iduser from user WHERE username='"+username+"'");
		ResultSet p=ReturnResult("SELECT iduser from user WHERE password='"+password+"'");
		u.next();
		p.next();
		String s1 = u.getString(1);
		String s2 = p.getString(1);
	    int uid = Integer.parseInt(s1);
	    int pid = Integer.parseInt(s2);
		if(uid==pid){
			System.out.print("correct"+uid);
		}
		
		return uid;
		
	}
	
	
	public static void main(String[]args) throws ClassNotFoundException, SQLException{
	
		signin("admin.username","password");
		
		//ResultQuery("select* from user");

		
		//while(result.next()){
			//System.out.println("  "+result.getString(1)+ "  " +result.getString(2));
		//}
	

}
}