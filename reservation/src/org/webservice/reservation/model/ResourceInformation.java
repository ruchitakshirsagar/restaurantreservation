package org.webservice.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table  (name="RESOURCE_INFORMATION")
public class ResourceInformation {

	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column (name="IMAGE_NUMBER") 
	private int imageNumber;
	
	@Column (name="IMAGE_LINK")
	private String imageLink;

	
	
	
	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
		
	
}
