package com.example.studentapp.service;

import com.example.studentapp.model.Course;
import com.example.studentapp.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findOne(Long id);

    List<Course> findAllCoursesByStudent(Long id);

    Course findOneCourseByStudent(Long studentId, Long courseId);

    Student create(Student student);

    Student update(Long id, Student student);

    void delete(Long id);

}
