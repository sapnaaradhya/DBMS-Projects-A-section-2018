package com.model;

public class Book {

	private int BID;
	private String MNAME;
	private String VENUE;
	private String DATE;
	private String TIME;
	private String SEATS;
	private String BOOKEDBY;
	private String BOOKEDON;
	
	public int getBID() {
		return BID;
	}
	public void setBID(int bID) {
		BID = bID;
	}
	public String getMNAME() {
		return MNAME;
	}
	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}
	public String getVENUE() {
		return VENUE;
	}
	public void setVENUE(String vENUE) {
		VENUE = vENUE;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	public String getSEATS() {
		return SEATS;
	}
	public void setSEATS(String sEATS) {
		SEATS = sEATS;
	}
	public String getBOOKEDBY() {
		return BOOKEDBY;
	}
	public void setBOOKEDBY(String bOOKEDBY) {
		BOOKEDBY = bOOKEDBY;
	}
	public String getBOOKEDON() {
		return BOOKEDON;
	}
	public void setBOOKEDON(String bOOKEDON) {
		BOOKEDON = bOOKEDON;
	} 
}
