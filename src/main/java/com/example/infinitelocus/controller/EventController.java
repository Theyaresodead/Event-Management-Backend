package com.example.infinitelocus.controller;

import com.example.infinitelocus.model.Event;
import com.example.infinitelocus.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<List<Event>>(eventService.getAllEvents(), HttpStatus.OK);
    }


    @PostMapping("/createEvent")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {

       return new ResponseEntity<Event>(event, HttpStatus.CREATED);
              // eventService.createEvent(event);
    }

    @GetMapping("/getUpcomingEvents")
    public ResponseEntity<List<Event>> getUpcomingEvents(@RequestParam Event event) {
        return new ResponseEntity<List<Event>>(eventService.getUpcomingEvents(event.time),
                HttpStatus.OK);
    }


}
