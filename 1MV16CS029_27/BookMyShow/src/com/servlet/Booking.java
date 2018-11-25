package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Booking extends HttpServlet{
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException{
			String moviesel=  request.getParameter("movieselected");
			String datesel=  request.getParameter("dateselected");
			String venuesel=  request.getParameter("venueselected");
			String timesel=  request.getParameter("timeselected");
			StringBuffer seatssel = new StringBuffer();
			System.out.println(moviesel + datesel + venuesel + timesel );
			
			try {
	           	Class.forName("org.sqlite.JDBC");
	            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\DataBase\\BookMyShow.sqlite");
	 
	            PreparedStatement ps = con.prepareStatement("SELECT SEATS FROM BOOKINGDETAILS WHERE MNAME=? and DATE=? and VENUE=? and TIME=? "); 
	            ps.setString(1, moviesel);
	            ps.setString(2, datesel);
	            ps.setString(3, venuesel);
	            ps.setString(4, timesel);
	                        
	           ResultSet rs = ps.executeQuery();
	           
	           while (rs.next()){
	        	   seatssel.append(rs.getString(1)).append(',');
	           }
	           System.out.println(seatssel.toString());
	           //request.getSession().setAttribute("BookedSeats", seatssel.toString());
	           	PrintWriter printWriter  = response.getWriter();
	            printWriter.println(seatssel.toString());
	            printWriter.close();
	            }catch (Exception e) {
	            System.out.println(e);
	        }
	        			
			}
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 	
		 	StringBuffer seats = new StringBuffer();
		 	
		 	String name = (String) request.getSession().getAttribute("name");
		 			 	
		 	Random randbid = new Random(); 
		 	int bid = randbid.nextInt(10000);
		 	String a1,b1,c1,d1,e1,f1 = null;
		 	String a2,b2,c2,d2,e2,f2 = null;
		 	String a3,b3,c3,d3,e3,f3 = null;
		 	String a4,b4,c4,d4,e4,f4 = null;
		 	String a5,b5,c5,d5,e5,f5 = null;
		 	String a6,b6,c6,d6,e6,f6 = null;
		 	String a7,b7,c7,d7,e7,f7 = null;
		 	String a8,b8,c8,d8,e8,f8 = null;
		 	String a9,b9,c9,d9,e9,f9 = null;
		 	String a10,b10,c10,d10,e10,f10 = null;
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String movie = request.getParameter("movie");
	        String date = request.getParameter("datepicker");
	        String venue = request.getParameter("venue");
	        String time =request.getParameter("times");
	        int totalCost=0;
	        int ticketPrice = 150;
	        a1 =request.getParameter("1A");
	        b1 =request.getParameter("1B");
	        c1 =request.getParameter("1C");
	        d1 =request.getParameter("1D");
	        e1 =request.getParameter("1E");
	        f1 =request.getParameter("1F");
           
	        a2 =request.getParameter("2A");
	        b2 =request.getParameter("2B");
	        c2 =request.getParameter("2C");
	        d2 =request.getParameter("2D");
	        e2 =request.getParameter("2E");
	        f2 =request.getParameter("2F");
	        
	        a3 =request.getParameter("3A");
	        b3 =request.getParameter("3B");
	        c3 =request.getParameter("3C");
	        d3 =request.getParameter("3D");
	        e3 =request.getParameter("3E");
	        f3 =request.getParameter("3F");
           
	        a4 =request.getParameter("4A");
	        b4 =request.getParameter("4B");
	        c4 =request.getParameter("4C");
	        d4 =request.getParameter("4D");
	        e4 =request.getParameter("4E");
	        f4 =request.getParameter("4F");
	        
	        a5 =request.getParameter("5A");
	        b5 =request.getParameter("5B");
	        c5 =request.getParameter("5C");
	        d5 =request.getParameter("5D");
	        e5 =request.getParameter("5E");
	        f5 =request.getParameter("5F");
           
	        a6 =request.getParameter("6A");
	        b6 =request.getParameter("6B");
	        c6 =request.getParameter("6C");
	        d6 =request.getParameter("6D");
	        e6 =request.getParameter("6E");
	        f6 =request.getParameter("6F");
	        
	        a7 =request.getParameter("7A");
	        b7 =request.getParameter("7B");
	        c7 =request.getParameter("7C");
	        d7 =request.getParameter("7D");
	        e7 =request.getParameter("7E");
	        f7 =request.getParameter("7F");
           
	        a8 =request.getParameter("8A");
	        b8 =request.getParameter("8B");
	        c8 =request.getParameter("8C");
	        d8 =request.getParameter("8D");
	        e8 =request.getParameter("8E");
	        f8 =request.getParameter("8F");
	        
	        a9 =request.getParameter("9A");
	        b9 =request.getParameter("9B");
	        c9 =request.getParameter("9C");
	        d9 =request.getParameter("9D");
	        e9 =request.getParameter("9E");
	        f9 =request.getParameter("9F");
           
	        a10 =request.getParameter("10A");
	        b10 =request.getParameter("10B");
	        c10 =request.getParameter("10C");
	        d10 =request.getParameter("10D");
	        e10 =request.getParameter("10E");
	        f10 =request.getParameter("10F");
            
	        if(a1 !=null){
	        	seats.append("1A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b1 !=null){
	        	seats.append("1B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c1!=null){
	        	seats.append("1C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d1!=null){
	        	seats.append("1D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e1!=null){
	        	seats.append("1E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f1!=null){
	        	seats.append("1F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a2!=null){
	        	seats.append("2A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b2!=null){
	        	seats.append("2B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c2!=null){
	        	seats.append("2C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d2!=null){
	        	seats.append("2D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e2!=null){
	        	seats.append("2E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f2!=null){
	        	seats.append("2F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a3!=null){
	        	seats.append("3A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b3!=null){
	        	seats.append("3B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c3!=null){
	        	seats.append("3C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d3!=null){
	        	seats.append("3D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e3!=null){
	        	seats.append("3E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f3!=null){
	        	seats.append("3F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a4!=null){
	        	seats.append("4A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b4!=null){
	        	seats.append("4B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c4!=null){
	        	seats.append("4C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d4!=null){
	        	seats.append("4D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e4!=null){
	        	seats.append("4E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f4!=null){
	        	seats.append("4F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a5!=null){
	        	seats.append("5A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b5!=null){
	        	seats.append("5B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c5!=null){
	        	seats.append("5C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d5!=null){
	        	seats.append("5D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e5!=null){
	        	seats.append("5E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f5!=null){
	        	seats.append("5F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a6!=null){
	        	seats.append("6A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b6!=null){
	        	seats.append("6B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c6!=null){
	        	seats.append("6C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d6!=null){
	        	seats.append("6D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e6!=null){
	        	seats.append("6E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f6!=null){
	        	seats.append("6F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a7!=null){
	        	seats.append("7A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b7!=null){
	        	seats.append("7B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c7!=null){
	        	seats.append("7C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d7!=null){
	        	seats.append("7D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e7!=null){
	        	seats.append("7E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f7!=null){
	        	seats.append("7F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a8!=null){
	        	seats.append("8A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b8!=null){
	        	seats.append("8B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c8!=null){
	        	seats.append("8C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d8!=null){
	        	seats.append("8D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e8!=null){
	        	seats.append("8E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f8!=null){
	        	seats.append("8F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a9!=null){
	        	seats.append("9A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b9!=null){
	        	seats.append("9B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c9!=null){
	        	seats.append("9C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d9!=null){
	        	seats.append("9D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e9!=null){
	        	seats.append("9E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f9!=null){
	        	seats.append("9F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        if(a10 !=null){
	        	seats.append("10A").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(b10!=null){
	        	seats.append("10B").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(c10!=null){
	        	seats.append("10C").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(d10!=null){
	        	seats.append("10D").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(e10!=null){
	        	seats.append("10E").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        if(f10!=null){
	        	seats.append("10F").append(',');
	        	totalCost = totalCost + ticketPrice ;
	        }
	        
	        try {
	        	
	        	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	            Date dateobj = new Date();
	        	String bookedon = df.format(dateobj);
	        	String selectedSeats = seats.toString();
	        	selectedSeats = selectedSeats.substring(0, selectedSeats.length() - 1);
	        	Class.forName("org.sqlite.JDBC");
	            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\DataBase\\BookMyShow.sqlite");
	 
	            PreparedStatement ps = con.prepareStatement("INSERT INTO BOOKINGDETAILS " + "VALUES (?,?,?,?,?,?,?,?,?)"); 
	            ps.setInt(1, bid);
	            ps.setString(2, movie);
	            ps.setString(3, venue);
	            ps.setString(4, date);
	            ps.setString(5, time);
	            ps.setString(6, selectedSeats);
	            ps.setString(7, name);
	            ps.setString(8, bookedon);
	            ps.setInt(9,totalCost);
	            
	            int result = ps.executeUpdate();
	            	            
	            if(result >0){
	            	request.getSession().setAttribute("bookID", bid);
	            	request.getSession().setAttribute("moviename", movie);
	            	request.getSession().setAttribute("venue", venue);
	            	request.getSession().setAttribute("date", date);
	            	request.getSession().setAttribute("time", time);
	            	request.getSession().setAttribute("selectedSeats", selectedSeats);
	            	request.getSession().setAttribute("price", totalCost);
	            	
	            	response.sendRedirect("/BookMyShow/success.jsp");
	 	        } else{
	 	        	response.sendRedirect("/BookMyShow/errorLogin.jsp");
	 	        }
	            }catch (Exception e) {
	            System.out.println(e);
	        }
	        //response.sendRedirect("/BookMyShow/movies.jsp");
	        out.close();
	    	 

}	
}