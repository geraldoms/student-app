package com.example.studentapp.controller.IT;

import com.example.studentapp.StudentAppApplication;
import com.example.studentapp.model.Course;
import com.example.studentapp.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudentAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {

    @LocalServerPort
    private int port;

    private URL baseURL;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp() throws MalformedURLException {
        this.baseURL = new URL("http://localhost:"+ port +"/api/v1/students");
    }

    @Test
    public void testFindAll() {

        final ResponseEntity<Student[]> response = restTemplate.getForEntity(this.baseURL.toString(), Student[].class);

        assertThat(response.getStatusCode().name(), is("OK"));

        final Student[] students = response.getBody();
        assertThat(students.length, is(3));
        assertThat(students[0].getFirstName(), is("John"));
        assertThat(students[1].getFirstName(), is("Richard"));
        assertThat(students[2].getFirstName(), is("Manuel"));
    }

    @Test
    public void testFindOne() {

        final ResponseEntity<Student> response = restTemplate.getForEntity(this.baseURL.toString() + "/1", Student.class);

        assertThat(response.getStatusCode().name(), is("OK"));
        assertThat(response, notNullValue());
        assertThat(response.getBody().getFirstName(), is("John"));
    }

    @Test
    public void testFindAllCoursesByStudent() {

        final ResponseEntity<Course[]> response = restTemplate.getForEntity(this.baseURL.toString() + "/2/courses", Course[].class);

        assertThat(response.getStatusCode().name(), is("OK"));

        final Course[] courses = response.getBody();
        assertThat(courses, notNullValue());
        assertThat(courses.length, is(1));
        assertThat(courses[0].getName(), is("History"));
    }

    @Test
    public void testFindOneCourseByStudent() {

        final ResponseEntity<Course> response = restTemplate.getForEntity(this.baseURL.toString() + "/3/courses/3", Course.class);

        assertThat(response.getStatusCode().name(), is("OK"));
        assertThat(response.getBody(), notNullValue());
        assertThat(response.getBody().getName(), is("Political Science"));
    }

    @Test
    public void testCreate() {

        final Student student = new Student(null, "FirstName", "LastName", "11223344", new Date(1988, 05, 20), new ArrayList<>(),
                new Date());

        final ResponseEntity<Student> response = restTemplate.postForEntity(this.baseURL.toString(), student, Student.class);

        assertThat(response.getStatusCode().name(), is("OK"));
        assertThat(response.getBody(), notNullValue());
        assertThat(response.getBody().getId(), is(4L));
        assertThat(response.getBody().getFirstName(), is("FirstName"));
    }

    @Test
    public void testDelete() {

        final int oldCounter = restTemplate.getForEntity(this.baseURL.toString(), Student[].class).getBody().length;
        final ResponseEntity<Void> response =
            restTemplate.exchange(this.baseURL.toString() + "/1", HttpMethod.DELETE, null, Void.class);
        final int newCounter = restTemplate.getForEntity(this.baseURL.toString(), Student[].class).getBody().length;

        assertThat(response.getStatusCode().name(), is("OK"));
        assertThat(oldCounter, is(newCounter + 1));
    }

    @Test
    public void testUpdate() {

        final Student student = new Student(1L, "FirstName2", "LastName2", "44332211", new Date(1989, 05, 20), new ArrayList<>(),
            new Date());

        final HttpEntity<Student> requestUpdate = new HttpEntity<>(student);
        final ResponseEntity<Student> response =
            restTemplate.exchange(this.baseURL.toString() + "/1", HttpMethod.PUT, requestUpdate, Student.class);

        assertThat(response.getStatusCode().name(), is("OK"));
        assertThat(response.getBody(), notNullValue());
        assertThat(response.getBody().getId(), is(1L));
        assertThat(response.getBody().getFirstName(), is("FirstName2"));
    }
}
