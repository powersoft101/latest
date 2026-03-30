package com.example.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.StudentDto;
import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	//
	private Student dtoToEntity(StudentDto dto) {
		Student s = new Student();

		s.setId(dto.getId());
		s.setName(dto.getName());

		return s;
	}

	//
	private StudentDto entityToDto(Student s) {
		StudentDto dto = new StudentDto();

		dto.setId(s.getId());
		dto.setName(s.getName());

		return dto;
	}

	@Override
	public StudentDto save(StudentDto dto) {

		Student s = dtoToEntity(dto);
		Student saved = repo.save(s);

		return entityToDto(saved);
	}

	@Override
	public List<StudentDto> getAll() {

		List<Student> list = repo.findAll();

		return list.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	@Override
	public StudentDto getById(Long id) {
		Student s = repo.findById(id).orElseThrow(() -> new RuntimeException("Student id not found: " + id));

		return entityToDto(s);
	}

	@Override
	public StudentDto updateById(Long id, StudentDto dto) {
		Student s = repo.findById(id).orElseThrow(() -> new RuntimeException("Student id not found: " + id));

		return entityToDto(s);
	}

	@Override
	public String deleteById(Long id) {

		if (!repo.existsById(id)) {
			throw new RuntimeException("Student id not found: " + id);
		}

		repo.deleteById(id);
		return "Student id deleted";
	}

}