package com.example.controller;

import com.example.Group;
import com.example.Album;
import com.example.Track;
//import com.example.repository.MusicRepository;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class MusicController {
    public List<Group> groups = new ArrayList<>();

    //Показать все группы
    @GetMapping("/")
    public Group reqGroup(Group group) {
        System.out.println(group.id + "   " + group.name);
        groups.add(group);
        return group;
    }

    //Показать все альбомы группы X
    //@GetMapping("/@{group.Id}/albums")
   // @GetMapping("/@{num}/albums")
  //  public Album reqAlbum(@RequestParam Long num, Album album) {
    @GetMapping("/X/albums")
    public Album reqAlbum(Album album) {
        System.out.println(album.id + "   " + album.name + "   " + album.year);
       // for (int i = 0; i < groups.size(); i++){
      //      if (groups.get(i).id.equals(num)){
      //          groups.get(i).album.add(album);
     //       }
      //  }
        return album;
    }

    //Показать все треки альбома Y группы X
    //@GetMapping("/@{group.Id}/albums/@{album.Id}/tracks")
    @GetMapping("/X/albums/Y/tracks")
    public Track reqTrack(Track track) {
        System.out.println(track.id + "   " + track.name + "   " + track.duration);
        //groups.get(X).albums.get(Y).tracks.add(track);
        return track;
    }

}