package com.example.models;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "PC_ALBUM")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="years")
    private String years;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Group_id")
    private Group group;
    @OneToMany(mappedBy = "album",cascade = CascadeType.ALL)
    private Set<Track> tracks = new HashSet<>();

    public Album(){}


    public Album(String name) {}

    public void addTrack(Track track){
        tracks.add(track);
        track.setAlbum(this);
    }
    public void removeTrack(Track track){
        tracks.remove(track);
        track.setAlbum(null);
    }
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setYears(String years) {this.years = years;}
    public String getYears() {return years;}

    public void setGroup(Group group) {this.group = group;}
    public Group getGroup() {return group;}

    public void setTracks(Set<Track> tracks) {this.tracks = tracks;}
    public Set<Track> getTracks() {return tracks;}
}
