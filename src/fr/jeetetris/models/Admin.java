package fr.jeetetris.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("0")
public class Admin extends User {
	
	private String password;
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public Admin() {
		super();
	}

	public Admin(String password) {
		super();
		this.password = password;
	}
}
