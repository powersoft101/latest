package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.StudentDto;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/create")
	public StudentDto addStudents(@RequestBody StudentDto dto) {
		return service.save(dto);
	}

	@GetMapping("/getAll")
	public List<StudentDto> getAllStudents() {
		return service.getAll();
	}

	@GetMapping("/getById/{id}")
	public StudentDto getStudentsById(@PathVariable Long id) {
		return service.getById(id);
	}

	@PutMapping("/updateById/{id}")
	public StudentDto updateStudentById(@PathVariable Long id, @RequestBody StudentDto dto) {
		return service.updateById(id, dto);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteStudentById(@PathVariable Long id) {
		return service.deleteById(id);
	}
}