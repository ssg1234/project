package com.hexa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="flightdetails")
public class FlightDetails {
	
	@Id
	@Column(name="flightid")
	private int flightId;
	
	@Column(name="flightname")
	private String flightName;
	
	@Column(name="src")
	private String src;
	
	@Column(name="dest")
	private String dest;
	
	@Column(name="fare")
	private double fare;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	
	@OneToMany(mappedBy="flight")
	private Set<FlightSchedule> flist;
	
	public Set<FlightSchedule> getElist(){
		return flist;
	}
	
	public void setElist(Set<FlightSchedule> flist) {
		this.flist = flist;
	}
}
