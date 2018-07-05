package com.example.studentapp.model;

import java.util.Date;
import java.util.List;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String memberId;
    private Date birthDate;
    private List<Course> courses;
    private Date createdAt;

    public Student() {
        
    }

    public Student(Long id, String firstName, String lastName, String memberId, Date birthDate, List<Course> courses,
                   Date createdAt) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberId = memberId;
        this.birthDate = birthDate;
        this.courses = courses;
        this.createdAt = createdAt;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getMemberId() {

        return memberId;
    }

    public void setMemberId(String memberId) {

        this.memberId = memberId;
    }

    public Date getBirthDate() {

        return birthDate;
    }

    public void setBirthDate(Date birthDate) {

        this.birthDate = birthDate;
    }

    public List<Course> getCourses() {

        return courses;
    }

    public void setCourses(List<Course> courses) {

        this.courses = courses;
    }

    public Date getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {

        this.createdAt = createdAt;
    }
}
