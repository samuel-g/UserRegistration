package com.samuelganta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuelganta.bean.UserBean;
import com.samuelganta.dao.UserDao;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public RegisterServlet() {
    }
    
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get input from brownser + save to bean
 		//Copying all the input parameters in to local variables
 		 String fullName = request.getParameter("fullname");
 		 String email = request.getParameter("email");
 		 String userName = request.getParameter("username");
 		 String password = request.getParameter("password");
 		 
 		 UserBean userBean = new UserBean();
 		 //Using Java Beans - An easiest way to play with group of related data
 		 userBean.setFullName(fullName);
 		 userBean.setEmail(email);
 		 userBean.setUserName(userName);
 		 userBean.setPassword(password);
 		 
 		 UserDao userDao = new UserDao();
 		
 		 //save userbean to databse
 		 String userRegistered = userDao.registerUser(userBean);
 		
 		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
 		 {

 			 request.setAttribute("name", userBean.getFullName());
 			 request.getRequestDispatcher("/Home.jsp").forward(request, response);
 		 }
 		 else   //On Failure, display a meaningful message to the User.
 		 {
 			 request.setAttribute("errMessage", userRegistered);
 			 request.getRequestDispatcher("/Register.jsp").forward(request, response);
 		 }
 		
 		
 	
		
	}

}
