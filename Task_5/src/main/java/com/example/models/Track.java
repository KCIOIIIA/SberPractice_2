package com.example.models;
import jakarta.persistence.*;
@Entity
@Table(name = "TRACK")
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
    public Album album;

    public void setId(Long id) { this.id = id;}
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
