package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"userEmail"}),
							@UniqueConstraint(columnNames = {"userPassword"})})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotEmpty(message = "Name can not be empty")
	@Pattern(regexp = "^[A-Z][a-z]+\\W[A-Z][a-z]+$",
			  message ="First letter of String Must be capital.Take a space between two string")
	private String userName;
	@NotEmpty(message = "Email can not be empty")
	@Email
	private String userEmail;
	@NotEmpty(message = "Password can not be empty")
	@Size(min = 8, message = "password should have at least 8 characters")
	private String userPassword;
	

}
