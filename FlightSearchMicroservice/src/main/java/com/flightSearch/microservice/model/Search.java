package com.flightSearch.microservice.model;

import java.time.LocalDate;

public class Search {
	
	private String source;
	private LocalDate departDate;
	private String destination;
	public Search(String source, LocalDate departDate, String destination) {
		super();
		this.source = source;
		this.departDate = departDate;
		this.destination = destination;
	}
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public LocalDate getDepartDate() {
		return departDate;
	}
	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "Search [source=" + source + ", departDate=" + departDate + ", destination=" + destination + "]";
	}
	
	

}
