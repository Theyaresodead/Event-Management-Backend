package com.example.infinitelocus.service;

import com.example.infinitelocus.repository.EventRepository;
import com.example.infinitelocus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private EventRepository eventRepository;
    public UserService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

}
