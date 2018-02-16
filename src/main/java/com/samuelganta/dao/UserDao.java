package com.samuelganta.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.samuelganta.bean.UserBean;

public class UserDao {

	public String registerUser(UserBean userBean) {

		String fullName = userBean.getFullName();
		String email = userBean.getEmail();
		String userName = userBean.getUserName();
		String password = userBean.getPassword();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		Statement stmt = null;
		try
		 {
			 con = DBConnection.createConnection();
			 //check if a table exists already
			/* 
			 *  USE usersdb; 
				 CREATE TABLE users 
				 (SlNo INTEGER not NULL AUTO_INCREMENT, 
				 PRIMARY KEY (SlNO),
				 fullName VARCHAR(30) NOT NULL,
				 Email VARCHAR(30) NOT NULL, 
				 userName VARCHAR(30) NOT NULL, 
				 password VARCHAR(30) NOT NULL);
			 * 	 }
			 * 
			 * use usersdb;

CREATE TABLE `users` (
  `SlNo` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `userName` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`SlNo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
			 * 
			 * */
		 
		 
		 
		 String query = "insert into users(SlNo,fullName,Email,userName,password) values (NULL,?,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, fullName);
		 preparedStatement.setString(2, email);
		 preparedStatement.setString(3, userName);
		 preparedStatement.setString(4, password);
		 
		 int i= preparedStatement.executeUpdate();
		 
		 if (i!=0)  //Just to ensure data has been inserted into the database
			 return "SUCCESS"; 
		 }
		
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		finally{
		      //finally block used to close resources
		      try{
		         if(preparedStatement!=null)
		            con.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		} //end finally
		 	return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }

		 
}
	
