package com.example.dto;

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
public class UserDto {
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
