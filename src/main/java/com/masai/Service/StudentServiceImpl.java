package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.StudentException;
import com.masai.Module.Student;
import com.masai.Repo.StudentRepo;


@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentRepo studentRepo;

	
	
	
	@Override
	public Student addStudent(Student student) throws StudentException {
	
		if(student==null) {
			
			throw new StudentException("Your data is null");
			
		}else{
			
		   return studentRepo.save(student);
		}
	}

	
	
	@Override
	public Student updateStudent(Student student,Integer studentId) throws StudentException {
		
	  Optional<Student> optional=studentRepo.findById(studentId);
	  
	  if(optional.isEmpty()) {
		  
		  throw new StudentException("Please Enter Correct id");
		  
	  }else {
		  
		   Student  student2=optional.get();
		   student2.setName(student.getName());
		   student2.setMarks(student.getMarks());
           student2.setEmailId(student.getEmailId());
           
          return studentRepo.save(student2);
	  }
		
	}

	
	
	
	@Override
	public Student getStudentById(Integer studentId) throws StudentException {
		
		Optional<Student> optional=studentRepo.findById(studentId);
		
		if(optional.isEmpty()) {
			
			throw new StudentException("Enter correct id");
			
		}else {
			
			return optional.get();
		}
	}
	
	
	

	@Override
	public List<Student> getAllStudent() throws StudentException {
		
		List<Student> list=studentRepo.findAll();
		
		if(list.isEmpty()) {
			
			throw new StudentException("No Data Present");
			
		}else {
			
			return list;
		}
		
	}

	
	
	@Override
	public String deleteStudent(Integer studentId) throws StudentException {
		
		String message="Student data not deleted";
		
		Optional<Student> optional=studentRepo.findById(studentId);
		
		if(optional.isEmpty()) {
			
			throw new StudentException("Enter correct id");
			
		}else{
			
			Student student=optional.get();
			
			studentRepo.delete(student);
			
			message="Student data deleted";
		}
		
		return message;
	}

}
