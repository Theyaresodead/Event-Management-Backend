package com.example.infinitelocus.repository;

import com.example.infinitelocus.model.Event;
import com.example.infinitelocus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findUsersById(String username);
//    List<Event> findEventsByUser(String username);
}
