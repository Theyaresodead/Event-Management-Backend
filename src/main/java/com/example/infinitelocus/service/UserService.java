package com.example.infinitelocus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.infinitelocus.repository.EventRepository;
import com.example.infinitelocus.repository.UserRepository;


@Service
public class UserService {
    public EventRepository eventRepository;
    public UserRepository userRepository;

   
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}
