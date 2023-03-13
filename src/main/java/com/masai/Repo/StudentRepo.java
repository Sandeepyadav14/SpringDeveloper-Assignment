package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Module.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
