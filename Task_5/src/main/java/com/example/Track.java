package com.example;
import jakarta.persistence.*;
//@Entity
//@Table(name = "track")
public class Track {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String duration;
    public Long groupId;
    public Long albumId;

    public void setId(Long id) { this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public String getDuration() {
        return duration;
    }
}
