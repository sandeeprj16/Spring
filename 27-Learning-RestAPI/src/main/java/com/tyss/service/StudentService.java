package com.tyss.service;

import java.util.List;

import com.tyss.dto.AddStudentRequestDto;
import com.tyss.dto.StudentDto;

public interface StudentService {
	List<StudentDto> getAllStudents();

	StudentDto getStudentById(long id);

	StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

	void deleteStudentById(Long id);


}
