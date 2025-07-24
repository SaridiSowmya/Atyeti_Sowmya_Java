package com.example.OnlineCourseManagementProject.repository;

import com.example.OnlineCourseManagementProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}


