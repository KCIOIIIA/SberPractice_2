package com.example;
import javax.persistence.*;
@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String Name;
    public String Id;
    public String Duration;

    public Track(String Name, String Id, String Duration){
        this.Name = Name;
        this.Id = Id;
        this.Duration = Duration;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public String getName() {
        return Name;
    }
    public String getId() {
        return Id;
    }
    public String getDuration() {
        return Duration;
    }
}
