package com.example.myProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myProject.dto.UserDTO;
import com.example.myProject.model.User;
import com.example.myProject.repository.UserRepository;


//데이터 가공 역할
@Service
public class UserService {
//    private List<UserDTO> userList = new ArrayList<>();
//
//    // 샘플 데이터 추가
//    public UserService() {
//        userList.add(new UserDTO("Alice", 25));
//        userList.add(new UserDTO("Bob", 30));
//    }
//
//    // 전체 사용자 리스트 반환
//    public List<UserDTO> getAllUsers() {
//        return userList;
//    }
//
//    // 새로운 사용자 추가
//    public void addUser(UserDTO user) {
//        userList.add(user);
//    }
	
	  @Autowired
	    private UserRepository userRepository;

	    // 모든 사용자 가져오기
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    // 사용자 추가
	    public User addUser(User user) {
	        return userRepository.save(user);
	    }
}