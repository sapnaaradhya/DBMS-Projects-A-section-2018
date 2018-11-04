package com.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException{
			    this.doPost(request,response);
			}
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String n = request.getParameter("userName");
        String p = request.getParameter("password");
        String e = request.getParameter("email");
     
        try {
        	       	
        	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\DataBase\\BookMyShow.sqlite");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into USERDETAILS values(?,?,?)");
 
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, e.toLowerCase());
         
            int i = ps.executeUpdate();
            if (i > 0)
                //out.print("You are successfully registered...");
            	response.sendRedirect("/BookMyShow/successReg.jsp");
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
 
}
