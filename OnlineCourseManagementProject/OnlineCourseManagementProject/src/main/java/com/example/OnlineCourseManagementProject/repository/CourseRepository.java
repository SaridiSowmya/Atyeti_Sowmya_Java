package com.example.OnlineCourseManagementProject.repository;

import com.example.OnlineCourseManagementProject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {}

