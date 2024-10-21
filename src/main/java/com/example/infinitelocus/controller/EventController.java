package com.example.infinitelocus.controller;

import com.example.infinitelocus.model.Event;
import com.example.infinitelocus.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }


    @GetMapping("/createEvent")
    public Event createEvent(@RequestBody Event event) {
       return eventService.createEvent(event);
    }

    public List<Event> getUpcomingEvents(@RequestParam Event event) {
        return eventService.getUpcomingEvents(event.time);
    }

}
