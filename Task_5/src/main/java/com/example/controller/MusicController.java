package com.example.controller;

import com.example.Group;
import com.example.Album;
import com.example.Track;
//import com.example.repository.MusicRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class MusicController {
    public List<Group> groups = new ArrayList<>();
    public ArrayList<Integer> a = new ArrayList<>();

    public ArrayList<Integer> t = new ArrayList<>();
    public long g = 0;

    //Показать все группы
    @GetMapping("/groups")
    public List<Group> reqGroup() {
        return groups;
    }
    @PostMapping("/groups")
    public void addGroup(@RequestBody Group group) {
        group.id = g;
        g++;
        System.out.println(group.id + "   " + group.name);
        groups.add(group);
    }
    //Показать все альбомы группы id0
    @GetMapping("/groups/{id0}/albums")
    public List<Album> reqAlbum(@PathVariable long id0) {
        Group group = new Group();
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                group = groups.get(i);
            }
        }
        return group.album;
    }
    @PutMapping("/groups/{id0}/albums")
    public void addAlbum(@PathVariable long id0, @RequestBody Album album) {
        album.id = (long) groups.get((int) id0).album.size();
        System.out.println(album.id + "   " + album.name + "   " + album.year + "   " + album.tracks);
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                Group group = groups.get(i);
                if (group.album.size() == 0){

                }
                group.album.add(album);
            }
        }
    }

    //Показать все треки альбома id1 группы id0
    @GetMapping("/groups/{id0}/albums/{id1}/tracks")
    public List<Track> reqTrack(@PathVariable long id0, @PathVariable long id1) {
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
            }
        }
        return album.tracks;
    }
    @PutMapping("/groups/{id0}/albums/{id1}/tracks")
    public void addAlbum(@PathVariable long id0,  @PathVariable long id1, @RequestBody Track track) {
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
        }

    }

}