package com.example.studentapp.service;

import com.example.studentapp.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findOne(Long id);

    Course create(Course course);

    Course update(Long id, Course course);

    void delete(Long id);
}
