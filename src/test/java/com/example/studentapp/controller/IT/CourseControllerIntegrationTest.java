package com.example.studentapp.controller.IT;

import com.example.studentapp.StudentAppApplication;
import com.example.studentapp.model.Course;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudentAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private URL baseURL;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp() throws MalformedURLException {

        this.baseURL = new URL("http://localhost:"+ port +"/api/v1/courses");
    }

    @Test
    public void testFindAll() throws IOException {

        final ResponseEntity<Course[]> response = restTemplate.getForEntity(this.baseURL.toString(), Course[].class);

        assertThat(response.getStatusCode().name(), is("OK"));
        final Course[] courses = response.getBody();
        assertThat(courses.length, is(4));
        assertThat(courses[0].getName(), is("Computer Science"));
        assertThat(courses[1].getName(), is("History"));
        assertThat(courses[2].getName(), is("Political Science"));
        assertThat(courses[3].getName(), is("Mathematics"));
    }

    @Test
    public void testFindOne() throws IOException {

        final ResponseEntity<Course> response = restTemplate.getForEntity(this.baseURL.toString() + "/1", Course.class);

        assertThat(response.getStatusCode().name(), is("OK"));
        assertThat(response.getBody(), notNullValue());
        assertThat(response.getBody().getName(), is("Computer Science"));
    }
}
