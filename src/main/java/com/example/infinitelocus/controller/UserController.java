package com.example.infinitelocus.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.infinitelocus.model.Event;
import com.example.infinitelocus.repository.UserRepository;
import com.example.infinitelocus.service.EventService;
import com.example.infinitelocus.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private EventService eventService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}/events")
    public ResponseEntity<List<Event>> getUserEvents(
            @PathVariable String username,
            @PathVariable int id
            @RequestParam boolean userOrAdmin) {
        try {
            List<Event> events = userService.findEventByUser(username,id,  userOrAdmin);
            return ResponseEntity.ok(events);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> registerForEvent(
            @PathVariable String username,
            @PathVariable String title,
            @PathVariable int id,
            @PathVariable String location,
            @PathVariable LocalDateTime date,
            @PathVariable String eventId) {
        try {
            eventService.saveEvent( title, id
            , username,location, date);
            return ResponseEntity.ok("Registration successful");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }
}
