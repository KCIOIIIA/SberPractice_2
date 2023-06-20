package com.example;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String Name;
    public String Id;
    public String Year;
    public List<Track> tracks;

    public Album(String Name, String Id, String Year, List <Track> tracks){
        this.Name = Name;
        this.Id = Id;
        this.Year = Year;
        this.tracks = tracks;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public void setYear(String Year) {
        this.Year = Year;
    }
    public void setTrack(List<Track> tracks) {
        this.tracks = tracks;
    }
    public String getName() {
        return Name;
   }
    public String getId() {
        return Id;
    }
    public String getYear() {
        return Year;
    }
    public List<Track> getTracks() {
        return tracks;
    }

}
