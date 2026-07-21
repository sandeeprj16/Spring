package com.tyss.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UserDto {

	private String name;

	private String email;

	private String password;

	private Long phone;
}
