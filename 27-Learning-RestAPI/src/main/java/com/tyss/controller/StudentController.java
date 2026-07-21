package com.tyss.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.AddStudentRequestDto;
import com.tyss.dto.StudentDto;
import com.tyss.service.StudentService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
//@RequestMapping("\students")
public class StudentController {
	private final StudentService studentService;
	


@GetMapping("/students")
public List<StudentDto> getAllStudents(){
	 System.out.println("page access");
	 return studentService.getAllStudents();
}
	 
@GetMapping("/students/{id}")
public StudentDto getStudentById(@PathVariable long id){
	System.out.println("Student accesss..");
	return studentService.getStudentById(id);

 }
@GetMapping("/student/{id}/{name}")
public String s(@PathVariable long id, @PathVariable String name) {
    return "path variable "+id+"name: "+name;
}
@PostMapping("/student/name")
public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
	return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
}
@PostMapping("/sandy")
	String sandy(){
		return"sandeep";
	}
@DeleteMapping("/delete/{id}")
	public ResponseEntity <Void> deleteAStudent(@PathVariable Long id){
	studentService.deleteStudentById(id);
	return ResponseEntity.noContent().build();
}

}
