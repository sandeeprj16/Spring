package com.tyss.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.tyss.dto.AddStudentRequestDto;
import com.tyss.dto.StudentDto;
import com.tyss.entity.Student;
import com.tyss.repository.StudentRepository;
import com.tyss.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository studentRepository ;
	private final ModelMapper modelMapper;
	
	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = studentRepository.findAll();

//	    List<StudentDto> studentDtoList = students
//	            .stream()
//	            .map(student -> new StudentDto(
//	                    student.getId(),
//	                    student.getName(),
//	                    student.getEmail()))
//	            .toList();
//
//	    return studentDtoList;
		
		//without
		return students
	            .stream()
	            .map(student -> new StudentDto(
	                    student.getId(),
	                    student.getName(),
	                    student.getEmail()))
	            .toList();

	    
	}

	@Override
	public StudentDto getStudentById(long id) {

	    Student student = studentRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Student not found with id.. " + id));

	    return modelMapper.map(student, StudentDto.class);
	}
	@Override
	public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
		Student newStudent=modelMapper.map(addStudentRequestDto,Student.class);
		Student student=studentRepository.save(newStudent);
		return modelMapper.map(student,StudentDto.class);
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		if(!studentRepository.existsById(id)) {
			throw new IllegalArgumentException("student not found: "+id);
		}else {
			studentRepository.deleteById(id);
			System.out.println("deleted id: "+id);
		}
		
	}
	
}
