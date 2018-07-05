package com.example.studentapp.utils;

import com.example.studentapp.model.Course;
import com.example.studentapp.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentCourseStub {

    private static Map<Long, Student> students = new HashMap<>();
    private static Long studentCounter;
    private static Map<Long, Course> courses = new HashMap<>();
    private static Long courseCounter;

    static {

        // Some Stub data for courses
        Course course01 = new Course(1L, "Computer Science",
            "Computer science is the study of the theory and engineering for the design and use of computers.",
            new Date());
        Course course02 =
            new Course(2L, "History", "History is the study of the past as it is described in written documents.",
                new Date());
        Course course03 = new Course(3L, "Political Science",
            "Political science is a social science which deals with systems of governance.", new Date());
        Course course04 = new Course(4L, "Mathematics",
            "Mathematics is the study of such topics as quantity, structure, space, and change.", new Date());
        courses.put(1L, course01);
        courses.put(2L, course02);
        courses.put(3L, course03);
        courses.put(4L, course04);
        courseCounter = 4L;

        // Creating some stub data for students
        Student student01 = new Student(1L, "John", "Jackson", "88201818", new Date(1990, 02, 11),
            new ArrayList<>(Arrays.asList(course01, course04)), new Date());
        Student student02 = new Student(2L, "Richard", "Yok", "88201918", new Date(1993, 04, 21),
            new ArrayList<>(Arrays.asList(course02)), new Date());
        Student student03 = new Student(3L, "Manuel", "Weider", "88202018", new Date(1995, 10, 10),
            new ArrayList<>(Arrays.asList(course02, course03)), new Date());
        students.put(1L, student01);
        students.put(2L, student02);
        students.put(3L, student03);
        studentCounter = 3L;
    }

    public static List<Student> findAllStudents() {

        return new ArrayList<>(students.values());
    }

    public static Student findOneStudent(Long id) {

        return students.get(id);
    }

    public static List<Course> findAllCoursesByStudent(Long id) {

        return students.get(id)
                       .getCourses();
    }

    public static Course findOneCourseByStudent(Long studentId, Long courseId) {

        return students.get(studentId)
                       .getCourses()
                       .stream()
                       .filter(c -> c.getId().equals(courseId))
                       .findFirst()
                       .orElse(null);
    }

    public static Student createStudent(Student newStudent) {

        studentCounter++;
        newStudent.setId(studentCounter);
        students.put(studentCounter, newStudent);

        // Try to create each course
        newStudent.getCourses()
                  .forEach(c -> {
                      createCourse(c);
                  });

        return newStudent;
    }

    public static Student updateStudent(Long id, Student newStudent) {

        students.put(id, newStudent);
        return newStudent;
    }

    public static void deleteStudent(Long id) {

        students.remove(id);
    }

    public static List<Course> findAllCourses() {

        return new ArrayList<>(courses.values());
    }

    public static Course findOneCourse(Long id) {

        return courses.get(id);
    }

    public static Course createCourse(Course newCourse) {

        if (newCourse.getId() != null && courses.containsKey(newCourse.getId())) {
            return courses.get(newCourse.getId());
        }
        courseCounter++;
        newCourse.setId(courseCounter);
        courses.put(courseCounter, newCourse);
        return newCourse;
    }

    public static Course updateCourse(Long id, Course newCourse) {

        courses.put(id, newCourse);
        return newCourse;
    }

    public static void deleteCourse(Long id) {

        courses.remove(id);
    }

}
