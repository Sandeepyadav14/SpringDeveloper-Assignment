package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Module.Student;
import com.masai.Service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	
	
	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> postStudent(@RequestBody Student student){
		System.out.println(student);
	Student student2 =studentService.addStudent(student);
	
	return new ResponseEntity<Student>(student2,HttpStatus.OK);
	
	}
	
	
	
	@PutMapping("/updateStudent/{studentId}")
	public ResponseEntity<Student> updateStudentData(@RequestBody Student student,@PathVariable Integer studentId ){
		
		Student student2=studentService.updateStudent(student, studentId);
		
		return new ResponseEntity<Student>(student2,HttpStatus.OK);
		
	}

	
	
	@GetMapping("/getOneStudent/{studentId}")
	public ResponseEntity<Student> getOneStudnet(@PathVariable Integer studentId){
		
		Student student=studentService.getStudentById(studentId);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		List<Student> list=studentService.getAllStudent();
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deletestudentByid(@PathVariable Integer studentId){
		
		String message=studentService.deleteStudent(studentId);
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
