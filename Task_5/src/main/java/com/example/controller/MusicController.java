package com.example.controller;

import com.example.Group;
import com.example.Album;
import com.example.Track;
//import com.example.repository.MusicRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@RestController
@Controller
public class MusicController {
    public List<Group> groups = new ArrayList<>();
    public long g = 0;

    //Показать все группы
    @GetMapping("/groups")
    public String reqGroup(Model model){
        model.addAttribute("groups", groups);
        return "groups";
    }

    @PostMapping("/groups")
    public String addGroup(@RequestBody Group group){
        group.id = g;
        g++;
        System.out.println(group.id + "   " + group.name);
        groups.add(group);
        return "groups";
    }
    //Показать все альбомы группы id0
    @GetMapping("/groups/{id0}/albums")
    public String reqAlbum(@PathVariable long id0, Model model) {
        Group group = new Group();
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                group = groups.get(i);
                model.addAttribute("group", group.album);
            }
        }
        return "albums";
    }
    @PostMapping("/groups/{id0}/albums")
    public String addAlbum(@PathVariable long id0, @RequestBody Album album) {
        album.id = (long) groups.get((int) id0).album.size();
        album.groupId = id0;
        System.out.println(album.id + "   " + album.name + "   " + album.year + "   " + album.tracks);
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                Group group = groups.get(i);
                group.album.add(album);
            }
        }
        return "albums";
    }

    //Показать все треки альбома id1 группы id0
    @GetMapping("/groups/{id0}/albums/{id1}/tracks")
    public String reqTrack(@PathVariable long id0, @PathVariable long id1, Model model) {
        Group group = new Group();
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                group = groups.get(i);
            }
        }
        Album album = new Album();
        for (int i = 0; i < group.album.size(); i++){
            if (group.album.get(i).id.equals(id1)){
                album = group.album.get(i);
                model.addAttribute("group", album.tracks);
            }
        }
        return "tracks";
    }
    @PostMapping("/groups/{id0}/albums/{id1}/tracks")
    public String addAlbum(@PathVariable long id0,  @PathVariable long id1, @RequestBody Track track) {
        track.id = (long) groups.get((int) id0).album.get((int) id1).tracks.size();
        System.out.println(track.id + "   " + track.name + "   " + track.duration);
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                Group group = groups.get(i);
                for (int j = 0; j < group.album.size(); j++){
                    if (group.album.get(j).id.equals(id1)){
                        Album album = group.album.get(j);
                        album.tracks.add(track);
                    }
                }
            }
        } return "tracks";
    }
}