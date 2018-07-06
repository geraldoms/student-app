package com.example.studentapp.model;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {

    private static final long serialVersionUID = 4193794056868733402L;

    private Long id;
    private String name;
    private String description;
    private Date createdAt;

    public Course() {

    }

    public Course(Long id, String name, String description, Date createdAt) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Date getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {

        this.createdAt = createdAt;
    }

    @Override
    public String toString() {

        return "Course{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", createdAt=" + createdAt
            + '}';
    }
}
