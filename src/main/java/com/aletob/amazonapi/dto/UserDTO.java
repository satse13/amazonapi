package com.aletob.amazonapi.dto;

public class UserDTO {
	
	private Long id;
	private String firstName;
	private String secondName;
	private String email;
	
	
	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String secondName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", secondName=" + secondName + ", email=" + email + "]";
	}
	
}
