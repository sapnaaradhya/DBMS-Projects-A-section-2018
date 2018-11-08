package com.dao;

import java.util.List;

import com.model.Movie;

public interface MovieDAO {

	public void addMovie(Movie movie);
	 
    public List<String> getAllMovie(); 
 
    public void deleteUser(Movie movie);
}
