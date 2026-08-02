package com.tyss.service;

import java.util.List;
import java.util.Map;

import com.tyss.dto.AddStudentRequestDto;
import com.tyss.dto.StudentDto;

public interface StudentService {
	List<StudentDto> getAllStudents();

	StudentDto getStudentById(long id);

	StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

	void deleteStudentById(Long id);

	StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

	StudentDto updatePartialStudent(Long id, Map<String, Object> updates);


}
