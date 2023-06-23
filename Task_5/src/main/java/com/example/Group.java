package com.example;

import com.example.Album;
//import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
//@Entity
//@Table(name = "group")
public class Group {
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public List<Album> album;

    public Group() {
        album = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAlbum(List<Album> albums) {
        this.album = album;
    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public List<Album> getAlbum() {
        return album;
    }
}
