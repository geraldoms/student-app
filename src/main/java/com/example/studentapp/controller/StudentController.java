package com.example.studentapp.controller;

import com.example.studentapp.model.Course;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> findAll() {

        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findOne(@PathVariable Long id) {

        return studentService.findOne(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> findAllCoursesByStudent(@PathVariable Long id) {

        return studentService.findAllCoursesByStudent(id);
    }

    @GetMapping("/{studentId}/courses/{courseId}")
    public Course findOneCourseByStudent(@PathVariable Long studentId, @PathVariable Long courseId) {

        return studentService.findOneCourseByStudent(studentId, courseId);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {

        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {

        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        studentService.delete(id);
    }
}
