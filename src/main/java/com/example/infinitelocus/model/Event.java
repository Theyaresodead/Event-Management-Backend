package com.example.infinitelocus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "events" )
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String title;
    public String description;
    public String location;
  //  private String date;
    public LocalDateTime time;
    public int maxRegistration;
    public int currentRegistration=0;
    public List<String> registeredUsers;

}
