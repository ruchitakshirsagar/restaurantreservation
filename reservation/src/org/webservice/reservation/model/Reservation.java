package org.webservice.reservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table  (name="RESERVATION_DB")
public class Reservation {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column (name="RESERVATION_ID") 
	private int reservationId; // PK
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
		
	@Column (name="DATE")
	private Date date;
	
	@Column (name="TIME")
	private String time;
	
	@Column (name="EMAIL")
	private String email; 
	
	@Column(name="PHONE")
	private String phone;
		
	@Column (name="PARTY_SIZE")
	private int partySize;
		
	@Column(name="USER_TYPE")
	private boolean owner;	// TRUE=owner & FALSE=guest
	
	@Column(name="USER_TABLE")
	private String table; 
	
		
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPartySize() {
		return partySize;
	}
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isOwner() {
		return owner;
	}
	public void setOwner(boolean owner) {
		this.owner = owner;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	
	
	

}
