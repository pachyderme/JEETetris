package fr.jeetetris.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.INTEGER)
public class User {
	
	protected int id;
	
	protected String identifier;
	protected String email;
	protected String firstName;
	protected String lastName;
	
	protected int type;
	
	@Column(insertable = false, updatable = false)
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
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
	
	public User() {
		super();
	}

	public User(int id, String email, String firstName, String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.identifier = this.email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
