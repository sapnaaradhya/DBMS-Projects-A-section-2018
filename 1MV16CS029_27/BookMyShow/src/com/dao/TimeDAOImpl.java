package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Time;

public class TimeDAOImpl implements TimeDAO{

	@Override
	public void addMovie(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getAllTime() {
		List<String> s1 = new  ArrayList<String>();
		try {
	       	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\DataBase\\BookMyShow.sqlite");
            PreparedStatement ps = con.prepareStatement("select * from TIMEDETAILS");
            ResultSet rs = ps.executeQuery();
     	            
            while (rs.next()) {
                s1.add(rs.getString("TIME"));                
            }
            
            }catch (Exception e2) {
            System.out.println(e2);
        }
		return s1;
	}

	@Override
	public void deleteUser(Time time) {
		// TODO Auto-generated method stub
		
	}

}
