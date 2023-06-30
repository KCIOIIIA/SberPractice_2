package com.example.controller;

import com.example.models.Group;
import com.example.models.Album;
import com.example.models.Track;

import com.example.repository.AlbumRepository;
import com.example.repository.GroupRepository;
import com.example.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.*;

//@RestController
@Controller
public class MusicController {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    TrackRepository trackRepository;

    //ГРУППЫ
    @GetMapping("/groups")
    public String getGroup(Model model){
        model.addAttribute("groups", groupRepository.findAll());
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
        model.addAttribute("group", group);
        System.out.println(group.getId() + "   " + group.getName());
        groupRepository.save(group);
        return "groupAdd";
    }

    //АЛЬБОМЫ
    @GetMapping("/groups/{id0}/albums")
    public String getAlbum(@PathVariable long id0, Model model) {
        Optional<Group> group = groupRepository.findById(id0);
        System.out.println(group.get().getName());
        Optional<Album> album = albumRepository.findById(id0);
        System.out.println(album.get().getName());
        model.addAttribute("group", group.get().getAlbum());
        model.addAttribute("id0", id0);
        return "albums";
    }

    @GetMapping("/groups/{id0}/albums/add")
    public String crAlbum(@PathVariable long id0) {
        return "albumAdd";
    }
    @PostMapping("/groups/{id0}/albums/add")
    public String addAlbum(@PathVariable long id0, @RequestParam("name") String name,
                           @RequestParam("years") String years, Model model) {
        Optional<Group> groupOptional = groupRepository.findById(id0);
        System.out.println(name + " " + years);
        if (groupOptional.isPresent()){
                Group group = groupOptional.get();
                Album album = new Album();
                album.setName(name);
                album.setYears(years);
                group.addAlbum(album);
                groupRepository.save(group);
        }
        return "albumAdd";
    }

    //ТРЕКИ
    @GetMapping("/groups/{id0}/albums/{id1}/tracks")
    public String getTrack(@PathVariable long id0, @PathVariable long id1, Model model) {
        Optional<Group> group = groupRepository.findById(id0);
        System.out.println(group.get().getName());
        Optional<Album> album = albumRepository.findById(id0);
        System.out.println(album.get().getName());
        model.addAttribute("group", album.get().getTracks());
        model.addAttribute("id0", id0);
        model.addAttribute("id1", id1);
        return "tracks";
    }
    @GetMapping("/groups/{id0}/albums/{id1}/tracks/add")
    public String crTrack(@PathVariable long id0, @PathVariable long id1) {
        return "trackAdd";
    }
    @PostMapping("/groups/{id0}/albums/{id1}/tracks/add")
    public String addTrack(@PathVariable long id0, @PathVariable long id1, @RequestParam("name") String name,
                           @RequestParam("duration") String duration, Model model) {
        Optional<Group> groupOptional = groupRepository.findById(id0);
        Optional<Album> albumOptional = albumRepository.findById(id0);
        System.out.println(name + " " + duration);
        if (groupOptional.isPresent()){
            Group group = groupOptional.get();
            Album album = albumOptional.get();
            Track track = new Track();
            track.setName(name);
            track.setDuration(duration);
            album.addTrack(track);
            group.addAlbum(album);
            albumRepository.save(album);
            groupRepository.save(group);
        }
        return "trackAdd";
    }
}