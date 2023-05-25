package com.abc.springbootjpahibernatecurdapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table( name = "student_table",schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    @Column(name = "student_id", nullable = false)
    private long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "belongs_to_standard")
    private int standard;

}
