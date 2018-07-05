package com.example.studentapp.service.impl;

import com.example.studentapp.model.Course;
import com.example.studentapp.service.CourseService;
import com.example.studentapp.utils.StudentCourseStub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public List<Course> findAll() {

        return StudentCourseStub.findAllCourses();
    }

    @Override
    public Course findOne(Long id) {

        return StudentCourseStub.findOneCourse(id);
    }

    @Override
    public Course create(Course course) {

        return StudentCourseStub.createCourse(course);
    }

    @Override
    public Course update(Long id, Course course) {

        return StudentCourseStub.updateCourse(id, course);
    }

    @Override
    public void delete(Long id) {

        StudentCourseStub.deleteCourse(id);
    }
}
