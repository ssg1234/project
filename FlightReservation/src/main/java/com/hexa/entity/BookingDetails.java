package com.hexa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookingdetails")
public class BookingDetails {
	
	@Id
	@Column(name="pnrid")
	private int pnrId;
	
	@Column(name="passengers")
	private int passengers;
	
	public int getPnrId() {
		return pnrId;
	}
	public void setPnrId(int pnrId) {
		this.pnrId = pnrId;
	}
	
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	@ManyToOne
	@JoinColumn(name="cust_Id", referencedColumnName="custId")
	private CustomerDetails customer;
	public CustomerDetails getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDetails customer) {
		
		this.customer = customer;
		System.out.println("into set method");
	}
	@ManyToOne
	@JoinColumn(name="sch_Id", referencedColumnName="schId")
	private FlightSchedule schedule;
	public FlightSchedule getSchedule() {
		return schedule;
	}
	public void setSchedule(FlightSchedule schedule) {
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "Flight Id= " +schedule.getFlight().getFlightId() + "  " + "CustomerName="+ customer.getCustName() + "  " + 
	         "pnrId=" + pnrId + "  " + "Fare=" + schedule.getFlight().getFare() ;
	}
	
	
}
