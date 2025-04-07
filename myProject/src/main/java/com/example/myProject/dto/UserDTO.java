package com.example.myProject.dto;

//Data Transfer Object 주고받는 데이터 양식 설정
public class UserDTO {
	
	private String name;
    private int age;

    // 기본 생성자
    public UserDTO() {}

    // 생성자
    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
