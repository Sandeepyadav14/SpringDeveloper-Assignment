package com.masai.Module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollNo;
	
	@NotNull
	private String name;
	
	@NotNull
	private Integer marks;
	
	@Email
	private String emailId;

}
