package com.abc.springbootjpahibernatecurdapp.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "student_table",schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id")
    private long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "belongs_to_standard")
    private int standard;


    public Student(long id, String name, int standard) {
        this.id = id;
        this.name = name;
        this.standard = standard;
    }

    public Student() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard=" + standard +
                '}';
    }
}
