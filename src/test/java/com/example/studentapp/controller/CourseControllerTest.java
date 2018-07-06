package com.example.studentapp.controller;

import com.example.studentapp.model.Course;
import com.example.studentapp.service.CourseService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;

public class CourseControllerTest {

    @InjectMocks
    CourseController courseController;

    @Mock
    CourseService courseService;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {

        List<Course> courseList = new ArrayList<>();
        Course course = new Course(1L, "Java", "Computer programming language", new Date());
        courseList.add(course);
        Mockito.when(courseService.findAll())
               .thenReturn(courseList);

        List<Course> resultList = courseController.findAll();
        Mockito.verify(courseService, times(1)).findAll();
        assertThat(resultList.size(), is(1));
        assertThat(resultList.get(0).getId(), is(1L));
        assertThat(resultList.get(0).getName(), is("Java"));
    }

    @Test
    public void testFindOne() {

        Course course = new Course(1L, "Node", "NodeJs course", new Date());
        Mockito.when(courseService.findOne(1L))
               .thenReturn(course);

        Course result = courseController.findOne(1L);
        Mockito.verify(courseService, times(1)).findOne(1L);
        assertThat(result, Matchers.notNullValue());
        assertThat(result.getId(), is(1L));
        assertThat(result.getName(), is("Node"));
    }

}
