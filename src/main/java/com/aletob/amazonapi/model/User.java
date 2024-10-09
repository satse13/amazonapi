package com.aletob.amazonapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String firstName;
		private String secondName;
		private String email;

		public User() {
		}

		public User(Long id, String firstName, String secondName, String email) {
			this.id = id;
			this.firstName = firstName;
			this.secondName = secondName;
			this.email = email;
		}

		public User(String firstName, String secondName, String email) {
			this.firstName = firstName;
			this.secondName = secondName;
			this.email = email;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
			return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + "]";
		}
}
