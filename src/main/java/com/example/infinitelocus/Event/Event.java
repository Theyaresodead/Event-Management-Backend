package com.example.infinitelocus.Event;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Event {
    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private String date;
    private Date time;
    private int maxRegistration;
    private int currentRegistration=0;

}
