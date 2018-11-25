package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException{
			    this.doPost(request,response);
			}
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	 
	        String e = request.getParameter("email");
	        String p = request.getParameter("password");
	        String name = null;
            String email = null;
	     
	        try {
	        	       	
	        	Class.forName("org.sqlite.JDBC");
	            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\DataBase\\BookMyShow.sqlite");
	 
	            PreparedStatement ps = con.prepareStatement("select NAME,EMAIL from USERDETAILS where EMAIL = ? and PASSWORD=?");
	 
	            ps.setString(1, e.toLowerCase());
	            ps.setString(2, p);
	         	         
	            ResultSet rs = ps.executeQuery();
	            	            
	            while (rs.next()) {
	                //out.print("You are successfully registered...");
	            	name = rs.getString(1);
	            	email = rs.getString(2);
	            }
	            if(name != null && email !=null){
	            	request.getSession().setAttribute("name", name);
	            	response.sendRedirect("/BookMyShow/movies.jsp");
	 	        } else{
	 	        	response.sendRedirect("/BookMyShow/errorLogin.jsp");
	 	        }
	            }catch (Exception e2) {
	            System.out.println(e2);
	        }
	 
	        out.close();
	    	 

}
}