package Task_5;

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
}
