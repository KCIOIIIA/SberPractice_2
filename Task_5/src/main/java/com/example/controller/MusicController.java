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

import java.util.*;

//@RestController
@Controller
public class MusicController {

    @Autowired
    GroupRepository groupRepository;

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

    @Autowired
    AlbumRepository albumRepository;

    //АЛЬБОМЫ
    @GetMapping("/groups/{id0}/albums")
    public String getAlbum(@PathVariable long id0, Model model) {
        Optional<Group> group = Optional.of(new Group());
        group = groupRepository.findById(id0);
        System.out.println(group.get().getName());
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

        System.out.println("id0 = " + id0);

        Optional<Group> group = groupRepository.findById(id0);
        System.out.println("group.name = " + group.get().getName());

        Album album = new Album();
        album.setName(name);
        album.setYears(years);
        System.out.println(album.getId() + "   " + album.getName() + "   " +
                album.getYears() + "   " + album.getTracks());

        albumRepository.save(album);
       // groupRepository.save()        Как сохранить новый альбом, чтобы он отображался в группах?
        System.out.println("group.album = " + group.get().getAlbum());
        model.addAttribute("group", album);
        model.addAttribute("id0", id0);
        return "albumAdd";
    }



/*
    //TRACKS
    @Autowired
    TrackRepository trackRepository;

    @GetMapping("/getTrack")
    public List<Track> getTrack(){
        return trackRepository.findAll();
    }
    @PostMapping("/addTrack")
    public Track addTrack(@RequestBody Track track){
        System.out.println(track.getId() + "   " + track.getName() +
                "   " + track.getDuration());
        trackRepository.save(track);
        return track;
    }
    @DeleteMapping("/deleteTrack")
    public void deleteTrack(@RequestBody Track track){
        System.out.println(track.getId() + "   " + track.getName() +
                "   " + track.getDuration());
        trackRepository.delete(track);
    }

    //ALBUMS
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/getAlbum")
    public List<Album> getAlbum(){
        return albumRepository.findAll();
    }
    @PostMapping("/addAlbum")
    public Album addAlbum(@RequestBody Album album){
        System.out.println(album.getId() + "   " + album.getName() +
                "   " + album.getYear() + "   " + album.getTracks());
        albumRepository.save(album);
        return album;
    }
    @DeleteMapping("/deleteAlbum")
    public void deleteAlbum(@RequestBody Album album){
        System.out.println(album.getId() + "   " + album.getName() +
                "   " + album.getYear() + "   " + album.getTracks());
        albumRepository.delete(album);
    }

 */

/*
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
                model.addAttribute("id0", id0);
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
                model.addAttribute("id0", id0);
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
                model.addAttribute("id0", id0);
                model.addAttribute("id1", id1);
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
        System.out.println(track.id + "   " + track.name + "   " + track.duration);
        for (int i = 0; i < g; i++){
            if (groups.get(i).id.equals(id0)){
                Group group = groups.get(i);
                for (int j = 0; j < group.album.size(); j++){
                    if (group.album.get(j).id.equals(id1)){
                        Album album = group.album.get(j);
                        album.tracks.add(track);
                        model.addAttribute("group", track);
                        model.addAttribute("id0", id0);
                        model.addAttribute("id1", id1);
                    }
                }
            }
        } return "trackAdd";
    }
 */
}