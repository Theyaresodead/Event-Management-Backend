package com.example.infinitelocus.service;

import com.example.infinitelocus.model.Event;
import com.example.infinitelocus.repository.EventRepository;
import com.example.infinitelocus.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Service
public class EventService {
    public EventRepository eventRepository;
    public UserRepository userRepository;
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public UserRepository userRepository() {

    }
    public Event createEvent(Event event){
        return eventRepository.save(event);
    }
    public List<Event> getAllEvents(){
       return eventRepository.findAllEvents();
    }
    public List<Event> getUpcomingEvents(LocalDateTime date){
        return eventRepository.findByDate(date);
    }
    public Event saveEvent(String title
            ,String username,String location,LocalDateTime date){
        Event event= eventRepository.findEventById(id);
        if(event==null) {
            System.out.print("No events found");
            return null;
        }
            event.registeredUsers.add(username);
            userRepository.registerUser(username,title);
            return eventRepository.save(event);

    }
}
