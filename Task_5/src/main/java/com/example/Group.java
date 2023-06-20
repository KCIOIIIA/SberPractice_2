package com.example;

import com.example.Album;
import javax.persistence.*;

import java.util.List;
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String Name;
    public String Id;
    public List<Album> albums;

    public Group(String Name, String Id, List <Album> albums){
        this.Name = Name;
        this.Id = Id;
        this.albums = albums;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public void setAlbum(List<Album> albums) {
        this.albums = albums;
    }

    public String getName() {
        return Name;
    }
    public String getId() {
        return Id;
    }
    public List<Album> getAlbum() {
        return albums;
    }
}
