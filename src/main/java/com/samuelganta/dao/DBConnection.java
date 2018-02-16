package com.samuelganta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {

	public static Connection createConnection()

	{
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/usersdb"; //MySQL URL followed by the database name
		String username = "root"; //MySQL username
		String password = "5500"; //MySQL password*/
		
		//String url = "jdbc:mysql://rds-mysql-userregistration.clebdbvoyes9.us-east-1.rds.amazonaws.com/usersdb"; //MySQL URL followed by the database name
		//String url = "jdbc:mysql://rds-mysql-userregistration.clebdbvoyes9.us-east-1.rds.amazonaws.com/usersdb";
		
	//	String username = "samuelganta"; //MySQL username
	//	String password = "home5500"; //MySQL password
		
		
		try 
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
				
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
			//System.out.println("Printing connection object "+con);	
		}	 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con; 
	}
	}