package com.example.models;
import jakarta.persistence.*;
@Entity
@Table(name = "PC_TRACK")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="duration")
    private String duration;
    @ManyToOne
    @JoinColumn(name = "Album_id")
    private Album album;

    public void setId(Long id) { this.id = id;}
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getDuration() {
        return duration;
    }

    public void setAlbum(Album album) {this.album = album;}
    public Album getAlbum() {return album;}
}
