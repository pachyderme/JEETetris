package fr.jeetetris.models;

public class User {
	private String identifier;
	private String password;
	private String firstName;
	private String lastName;
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public User(String identifier, String password, String firstName, String lastName) {
		super();
		this.identifier = identifier;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
