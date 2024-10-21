package com.example.infinitelocus.service;

import com.example.infinitelocus.model.Event;
import com.example.infinitelocus.repository.EventRepository;
import com.example.infinitelocus.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EventService {
    public EventRepository eventRepository;
    public UserRepository userRepository;
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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
    public Event saveEvent(String title,int id
            ,String username,String location,LocalDateTime date){
        Event event= eventRepository.findEventById(id);
        if(event) {
            System.out.print("No events found");
        }
        else{

            event.add(new Event(title,username,));
            userRepository.registerUser(username,title);

        }

        return event;

    }
}
