package com.example.controller;

import com.example.Group;
import com.example.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicController {

    public List<Group> groups = new ArrayList<>();
    @Autowired
    MusicRepository musicRepository;

    @RequestMapping(value = "/groups")
    public String groupsController(Model model) {
        model.addAttribute("groups", groups);
        return "groups";
        //return musicRepository.save(groups)
    }


  //  @GetMapping("/groups")
   // @PostMapping("/groups/{groups.id}")

    @RequestMapping(value = "/groups/albums")
    public String albumsController(Model model) {
        model.addAttribute("groups", groups);
        return "albums";
    }
    @RequestMapping(value = "/groups/albums/tracks")
    public String tracksController(Model model) {
        model.addAttribute("groups", groups);
        return "tracks";
    }

}