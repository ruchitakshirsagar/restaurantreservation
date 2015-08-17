package org.webservice.reservation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity 
@Table  (name="MENU_DB")
public class Menu {
	
	@Id
	@Column(name="CATEGORY")
	private String menuCategory;

	
	@ElementCollection (fetch=FetchType.EAGER)
	@JoinTable (name="MENU_DESCRIPTIONS", joinColumns = @JoinColumn(name="CATEGORY") )
	private List<String> descriptions;
	
	
	
	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	public List<String> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}
	
	
	
	
}
