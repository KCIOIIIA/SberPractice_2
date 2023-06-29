package com.example.models;

import com.example.repository.AlbumRepository;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PC_GROUP")

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private Set<Album> albums = new HashSet<>();
    public Group(){}

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAlbum(Set<Album> albums) { this.albums = albums; }
    public Set<Album> getAlbum() { return albums; }


}
