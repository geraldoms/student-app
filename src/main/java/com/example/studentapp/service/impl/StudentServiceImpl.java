package com.example.studentapp.service.impl;

import com.example.studentapp.model.Course;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import com.example.studentapp.utils.StudentCourseStub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAll() {

        return StudentCourseStub.findAllStudents();
    }

    @Override
    public Student findOne(Long id) {

        return StudentCourseStub.findOneStudent(id);
    }

    @Override
    public List<Course> findAllCoursesByStudent(Long id) {

        return StudentCourseStub.findAllCoursesByStudent(id);
    }

    @Override
    public Course findOneCourseByStudent(Long studentId, Long courseId) {

        return StudentCourseStub.findOneCourseByStudent(studentId, courseId);
    }

    @Override
    public Student create(Student student) {

        return StudentCourseStub.createStudent(student);
    }

    @Override
    public Student update(Long id, Student student) {

        return StudentCourseStub.updateStudent(id, student);
    }

    @Override
    public void delete(Long id) {

        StudentCourseStub.deleteStudent(id);
    }
}
