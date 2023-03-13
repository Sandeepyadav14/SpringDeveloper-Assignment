package com.masai.Service;

import java.util.List;

import com.masai.Exception.StudentException;
import com.masai.Module.Student;

public interface StudentService {

	Student addStudent(Student student)throws StudentException;
	
	Student updateStudent(Student student,Integer studentId) throws StudentException;
	
	Student getStudentById(Integer studentId) throws StudentException;
	
	List<Student> getAllStudent() throws StudentException;
	
	String deleteStudent(Integer studentId) throws StudentException;
	
	
}
