package com.example.task_5;

import java.util.List;

public class Album {
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

 //   public String getName() {
 //       return Name;
//   }
 //   public String getId() {
 //       return Id;
 //   }
 //   public String getYear() {
 //       return Year;
 //   }
 //   public List<Track> getTracks() {
  //      return tracks;
  //  }

}
