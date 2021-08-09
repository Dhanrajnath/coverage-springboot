package com.luv2code.springdemo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotNull(message = "required")
	@Size(min=1, message="is required")

	@Column(name="first_name")
	private String firstName;

	@NotNull(message = "required")
	@Size(min=1, message="is required")

	@Column(name="last_name")
	private String lastName;

	@NotNull(message = "required")
	@Column(name="email")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "please enter a valid email id!")
	private String email;
	
	public Customer() {
	}

	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}