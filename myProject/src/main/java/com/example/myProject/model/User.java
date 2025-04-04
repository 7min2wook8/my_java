package com.example.myProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // PostgreSQL 테이블명
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private int age;

    // 기본 생성자
    public User() {}

    // 생성자
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}