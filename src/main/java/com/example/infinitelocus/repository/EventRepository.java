package com.example.infinitelocus.repository;


import com.example.infinitelocus.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
   List<Event> findEventsByTitle(String title);
   List<Event> findEventsByUserId(String userId);
   List<Event> findByDate(LocalDateTime date);
   List<Event> findAllEvents();
   Event findEventById(int id);
   Event registerForEvent(String title,String username,String location, LocalDateTime date);
  // List<Event> findByTitleAndUserId(String title, String userId);
}