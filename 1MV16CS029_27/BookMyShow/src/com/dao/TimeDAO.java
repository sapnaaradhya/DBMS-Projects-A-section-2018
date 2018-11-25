package com.dao;

import java.util.List;
import com.model.Time;

public interface TimeDAO {

	public void addMovie(Time time);
	 
    public List<String> getAllTime(); 
 
    public void deleteUser(Time time);

}
