package com.example.service;

import java.util.List;

import com.example.dto.StudentDto;

public interface StudentService {

	StudentDto save(StudentDto dto);

	List<StudentDto> getAll();

	StudentDto getById(Long id);

	StudentDto updateById(Long id, StudentDto dto);

	String deleteById(Long id);
}