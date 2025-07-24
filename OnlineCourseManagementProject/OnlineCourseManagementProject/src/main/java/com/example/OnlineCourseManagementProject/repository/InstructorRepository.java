package com.example.OnlineCourseManagementProject.repository;

import com.example.OnlineCourseManagementProject.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {}

