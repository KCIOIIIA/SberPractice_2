package com.example;

import com.example.Album;

import java.util.List;

public class Group {
    public String Name;
    public String Id;
    public List<Album> albums;

    public Group(String Name, String Id, List <Album> albums){
        this.Name = Name;
        this.Id = Id;
        this.albums = albums;
    }

  //  public String getName() {
  //      return Name;
  //  }
 //   public String getId() {
  //      return Id;
  //  }
  //  public List<Album> getAlbums() {
  //      return albums;
  //  }
}
