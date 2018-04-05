package com.hexa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="custdetails")
public class CustomerDetails {
	
	@Id
	@Column(name="custid")
	private int custId;
	
	@Column(name="custname")
	private String custName;
	
	@Column(name="pwd")
	private String pwd;
	
	@Column(name="mobno")
	private long mobNo;
	
	@Column(name="emailid")
	private String emailId;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@OneToMany(mappedBy="customer")
	private Set<BookingDetails> blist;
	public Set<BookingDetails> getBlist() {
		return blist;
	}
	public void setBlist(Set<BookingDetails> blist) {
		this.blist = blist;
	}
	@Override
	public String toString() {
		return "custId=" + custId ;
	}
	
	
	
}
