package org.webservice.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table  (name="MESSAGE_DB")
public class Message {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int messageId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MESSAGE")
	private String message;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
