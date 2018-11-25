package com.dao;

import java.util.List;

import com.model.Venue;


public interface VenueDAO {
	
	public void addMovie(Venue venue);
	 
    public List<String> getAllVenue(); 
 
    public void deleteUser(Venue venue);
}
