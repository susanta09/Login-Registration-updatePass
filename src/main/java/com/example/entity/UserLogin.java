package com.example.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
	@NotEmpty(message = "Email can not be empty")
	@Email
	private String userEmail;
	@NotEmpty(message = "Password can not be empty")
	@Size(min = 8, message = "password should have at least 8 characters")
	private String userPassword;
}
