package com.tyss.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentRequestDto {
	@NotBlank(message = "name is required")
	@Size(min = 3,max=10, message = "name should be length 3 to 10 characters")
	private String name;
	
	@Email
	@NotBlank(message = "email is required")
	private String email;
}
