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
    public String getGroup(Model model){
        model.addAttribute("groups", groups);
        return "groups";
    }
    @GetMapping("/groups/add")
    public String crGroup(){
        return "groupAdd";
    }
    @PostMapping("/groups/add")
    public String createGroup(@RequestParam("name") String name, Model model){
        Group group = new Group();
        group.setName(name);
        group.id = g;
        g++;
        model.addAttribute("group", group);
        System.out.println(group.id + "   " + group.name);
        groups.add(group);
        return "groupAdd";
    }

    //Показать все альбомы группы id0
    @GetMapping("/groups/{id0}/albums")
    public String getAlbum(@PathVariable long id0, Model model) {
        Group group = new Group();
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                group = groups.get(i);
                model.addAttribute("group", group.album);
                model.addAttribute("album", group.album.get(0));
            }
        }
        return "albums";
    }
    @GetMapping("/groups/{id0}/albums/add")
    public String crAlbum(@PathVariable long id0) {
        return "albumAdd";
    }
    @PostMapping("/groups/{id0}/albums/add")
    public String addAlbum(@PathVariable long id0, @RequestParam("name") String name,
                           @RequestParam("year") String year, Model model) {
        Album album = new Album();
        album.id = (long) groups.get((int) id0).album.size();
        album.groupId = id0;
        album.setName(name);
        album.setYear(year);
        System.out.println(album.id + "   " + album.name + "   " + album.year + "   " + album.tracks);
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                Group group = groups.get(i);
                group.album.add(album);
                model.addAttribute("group", album);
            }
        }
        return "albumAdd";
    }

    //Показать все треки альбома id1 группы id0
    @GetMapping("/groups/{id0}/albums/{id1}/tracks")
    public String getTrack(@PathVariable long id0, @PathVariable long id1, Model model) {
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
                model.addAttribute("album", album.tracks.get(0));
            }
        }
        return "tracks";
    }

    @GetMapping("/groups/{id0}/albums/{id1}/tracks/add")
    public String crTrack(@PathVariable long id0, @PathVariable long id1) {
        return "trackAdd";
    }
    @PostMapping("/groups/{id0}/albums/{id1}/tracks/add")
    public String addAlbum(@PathVariable long id0, @PathVariable long id1,
                           @RequestParam("name") String name,
                           @RequestParam("duration") String duration, Model model) {
        Track track = new Track();
        track.id = (long) groups.get((int) id0).album.get((int) id1).tracks.size();
        track.setName(name);
        track.setDuration(duration);
        track.groupId = id0;
        track.albumId = id1;
        System.out.println(track.id + "   " + track.name + "   " + track.duration);
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                Group group = groups.get(i);
                for (int j = 0; j < group.album.size(); j++){
                    if (group.album.get(j).id.equals(id1)){
                        Album album = group.album.get(j);
                        album.tracks.add(track);
                        model.addAttribute("group", track);
                    }
                }
            }
        } return "trackAdd";
    }
}