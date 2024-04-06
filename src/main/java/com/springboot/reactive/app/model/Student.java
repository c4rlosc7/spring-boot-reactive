package com.springboot.reactive.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.concurrent.ThreadLocalRandom;

@Table("STUDENTS")
public class Student {
    @Id
    private Long id;
    private String name;
    @Column("LAST_NAME")
    private String lastName;
    @Column("ENROLL_ID")
    private Long enrollId;
    private StateStudent state;

    public Student() {
    }
    public Student(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.enrollId = generateAndValidID();
        this.state = StateStudent.ENROLLED;
    }

    public Student(Long id, Long enrollId, String name, String lastName, StateStudent state) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.enrollId = enrollId;
        this.state = state;
    }

    public enum StateStudent {
        ENROLLED, NON_ENROLLED
    }

    private Long generateAndValidID() {
        Long enrollId = ThreadLocalRandom.current().nextLong(10000000L, 100000000L);
        return enrollId;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Long enrollId) {
        this.enrollId = enrollId;
    }

    public StateStudent getState() {
        return state;
    }

    public void setState(StateStudent state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrollId=" + enrollId +
                ", Name=" + getName() +
                ", Lastname=" + getLastName() +
                ", state=" + state +
                '}';
    }
}
