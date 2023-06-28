package com.example.models;
import jakarta.persistence.*;
import com.example.models.Track;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "ALBUM")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="year")
    private String year;
    @OneToMany(cascade = CascadeType.ALL)
    public Set<Track> tracks = new HashSet<>();

    public Album() {
    }
    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setYear(String year) {this.year = year;}
    public void setTrack(Set<Track> tracks) {this.tracks = tracks;}
    public String getName() {return name;}
    public Long getId() {return id;}
    public String getYear() {return year;}
    public Set<Track> getTracks() {return tracks;}
}
