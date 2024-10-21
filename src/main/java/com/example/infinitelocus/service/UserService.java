package com.example.infinitelocus.service;

import com.example.infinitelocus.model.Event;
import com.example.infinitelocus.model.User;
import com.example.infinitelocus.repository.EventRepository;
import com.example.infinitelocus.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private EventRepository eventRepository;
    public UserService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public List<Event> findEventByUser(String username, int id, boolean userOrAdmin){

        User user = userRepository.findUsersByName(username, userOrAdmin);
       
        if (user == null) {
           
            throw new RuntimeException("User not found");
        }

        if (userOrAdmin) {
           
            return eventRepository.findEventsByUserId(id);
        } else {
           
            return eventRepository.findEventsByUserId(id);
        }
    }
}
