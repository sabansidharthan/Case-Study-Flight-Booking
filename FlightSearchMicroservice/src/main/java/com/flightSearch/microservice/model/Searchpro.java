package com.flightSearch.microservice.model;

public class Searchpro {
	private String source;
	private String departDate;
	private String destination;
	public Searchpro(String source, String departDate, String destination) {
		super();
		this.source = source;
		this.departDate = departDate;
		this.destination = destination;
	}
	public Searchpro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String departDate) {
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
		return "Searchpro [source=" + source + ", departDate=" + departDate + ", destination=" + destination + "]";
	}
	

}
