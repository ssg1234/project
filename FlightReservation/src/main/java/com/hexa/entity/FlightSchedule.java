package com.hexa.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="flightschedule")
public class FlightSchedule {
	
	@Id
	@Column(name="schid")
	private int schId;
	
	@Column(name="schdate")
	private Date schDate;
	
	@Column(name="seats")
	private int seats;
	
	
	public int getSchId() {
		return schId;
	}
	public void setSchId(int schId) {
		this.schId = schId;
	}
	public Date getSchDate() {
		return schDate;
	}
	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	@ManyToOne
	@JoinColumn(name="fli_id", referencedColumnName="flightId")
	private FlightDetails flight;
	public FlightDetails getFlight() {
		return flight;
	}
	public void setFlight(FlightDetails flight) {
		this.flight = flight;
	}
	
	@OneToMany(mappedBy="schedule")
	private Set<BookingDetails> booklist;
	public Set<BookingDetails> getBooklist() {
		return booklist;
	}
	public void setBooklist(Set<BookingDetails> booklist) {
		this.booklist = booklist;
	}
	@Override
	public String toString() {
		return "FlightSchedule [schId=" + schId + ", schDate=" + schDate + ", seats=" + seats + "flightId" +flight.getFlightName()
				+ "]";
	}
	
	
	
}
