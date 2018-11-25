package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Movie;

public class MovieDAOImpl implements MovieDAO{

	@Override
	public void addMovie(Movie movie) {
		
	}

	@Override
	public List<String> getAllMovie() {
		List<String> s1 = new  ArrayList<String>();
		try {
	       	Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\DataBase\\BookMyShow.sqlite");
            PreparedStatement ps = con.prepareStatement("select * from MOVIEDETAILS");
            ResultSet rs = ps.executeQuery();
     	            
            while (rs.next()) {
                s1.add(rs.getString("MNAME"));                
            }
            
            }catch (Exception e2) {
            System.out.println(e2);
        }
		return s1;
	}

	@Override
	public void deleteUser(Movie movie) {
		// TODO Auto-generated method stub
		
	}

}
