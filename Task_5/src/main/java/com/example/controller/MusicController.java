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
    public long g = 0;

    //Показать все группы
    @GetMapping("/")
    public Group reqGroup(Group group) {
        group.id = g;
        g++;
        System.out.println(group.id + "   " + group.name);
        groups.add(group);
        return group;
    }

    //Показать все альбомы группы id0
    @GetMapping("/{id0}/albums")
    public Album reqAlbum(@PathVariable long id0, Album album) {
        album.id = g;
        g++;
        System.out.println(album.id + "   " + album.name + "   " + album.year + "   " + album.tracks);
        Group group = new Group();
        group.album.add(album);
        return album;
    }

    //Показать все треки альбома id1 группы id0
    @GetMapping("/{id0}/albums/{id1}/tracks")
    public Track reqTrack(@PathVariable long id0, @PathVariable long id1, Track track) {
        track.id = g;
        g++;
        System.out.println(track.id + "   " + track.name + "   " + track.duration);
        Album album = new Album();
        album.tracks.add(track);
        Group group = new Group();
        group.album.add(album);
        return track;
    }

}