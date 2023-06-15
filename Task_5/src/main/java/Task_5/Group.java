package Task_5;

import java.util.ArrayList;
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
}
