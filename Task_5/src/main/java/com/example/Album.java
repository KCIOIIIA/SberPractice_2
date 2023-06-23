package com.example;
//import javax.persistence.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
//@Entity
//@Table(name = "album")
public class Album {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String year;
    public List<Track> tracks;

    public Album() {
        tracks = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public void setTrack(List<Track> tracks) {
        this.tracks = tracks;
    }
    public String getName() {
        return name;
   }
    public Long getId() {
        return id;
    }
    public String getYear() {
        return year;
    }
    public List<Track> getTracks() {
        return tracks;
    }
}
