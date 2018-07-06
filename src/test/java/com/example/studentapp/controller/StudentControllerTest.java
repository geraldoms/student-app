package com.example.studentapp.controller;

import com.example.studentapp.model.Course;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
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
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {

        List<Student> studentList = new ArrayList<>();
        Student student =
            new Student(1L, "FirstName", "LastName", "22112211", new Date(1990, 02, 11), new ArrayList<>(), new Date());
        studentList.add(student);
        Mockito.when(studentService.findAll())
               .thenReturn(studentList);

        List<Student> resultList = studentController.findAll();
        verify(studentService, times(1)).findAll();
        assertThat(resultList.size(), is(1));
        assertThat(resultList.get(0).getCourses().size(), is(0));
        assertThat(resultList.get(0).getId(), is(1L));
        assertThat(resultList.get(0).getFirstName(), is("FirstName"));
        assertThat(resultList.get(0).getMemberId(), is("22112211"));
    }

    @Test
    public void testFindOne() {

        Student student =
            new Student(1L, "FirstName2", "LastName2", "11331133", new Date(1994, 05, 20), new ArrayList<>(),
                new Date());
        Mockito.when(studentService.findOne(1L))
               .thenReturn(student);

        Student result = studentController.findOne(1L);
        verify(studentService, times(1)).findOne(1L);
        assertThat(result, Matchers.notNullValue());
        assertThat(result.getId(), is(1L));
        assertThat(result.getFirstName(), is("FirstName2"));
        assertThat(result.getMemberId(), is("11331133"));
    }

    @Test
    public void testCreate() {

        Student student =
            new Student(1L, "FirstName3", "LastName3", "33221122", new Date(1995, 05, 20), new ArrayList<>(),
                new Date());
        Mockito.when(studentService.create(any()))
               .thenReturn(student);

        Student result = studentController.create(student);
        verify(studentService, times(1)).create(student);
        assertThat(result, Matchers.notNullValue());
        assertThat(result.getId(), is(1L));
        assertThat(result.getFirstName(), is("FirstName3"));
        assertThat(result.getMemberId(), is("33221122"));
    }

    @Test
    public void testUpdate() {

        Student student =
            new Student(1L, "FirstName4", "LastName4", "33223344", new Date(1995, 05, 20), new ArrayList<>(),
                new Date());
        Mockito.when(studentService.update(Mockito.anyLong(), any()))
               .thenReturn(student);

        Student result = studentController.update(1L, student);
        verify(studentService, times(1)).update(1L, student);
        assertThat(result, Matchers.notNullValue());
        assertThat(result.getId(), is(1L));
        assertThat(result.getFirstName(), is("FirstName4"));
        assertThat(result.getMemberId(), is("33223344"));
    }

    @Test
    public void testDelete() {

        Mockito.doNothing().when(studentService).delete(1L);
        studentController.delete(1L);
        verify(studentService, times(1)).delete(1L);
    }

    @Test
    public void testFindAllCoursesByStudent() {

        List<Course> courseList = new ArrayList<>();
        Course course01 = new Course(1L, "Java", "Computer programming language", new Date());
        Course course02 = new Course(2L, "Node", "NodeJs course", new Date());
        courseList.add(course01);
        courseList.add(course02);

        Mockito.when(studentService.findAllCoursesByStudent(1L))
               .thenReturn(courseList);

        List<Course> resultList = studentController.findAllCoursesByStudent(1L);
        verify(studentService, times(1)).findAllCoursesByStudent(1L);
        assertThat(resultList, Matchers.notNullValue());
        assertThat(resultList.size(), is(2));
        assertThat(resultList.get(0).getId(), is(1L));
        assertThat(resultList.get(0).getName(), is("Java"));
        assertThat(resultList.get(1).getId(), is(2L));
        assertThat(resultList.get(1).getName(), is("Node"));
    }

    @Test
    public void testFindOneCourseByStudent() {

        Course course = new Course(2L, "Node", "NodeJs course", new Date());
        Mockito.when(studentService.findOneCourseByStudent(1L, 2L))
               .thenReturn(course);

        Course result = studentController.findOneCourseByStudent(1L, 2L);
        verify(studentService, times(1)).findOneCourseByStudent(1L, 2L);
        assertThat(result, Matchers.notNullValue());
        assertThat(result.getId(), is(2L));
        assertThat(result.getName(), is("Node"));
    }
}
