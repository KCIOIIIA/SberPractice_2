package com.example.controller;

import com.example.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicController {

    @RequestMapping(value = "/groups")
    public String groupsController(Model model) {
        List<Group> groups = new ArrayList<>();
        model.addAttribute("groups", groups);
        return "groups";
    }

    // @RequestMapping(value = "/groups/${group.id}/albums")
   // public String albumsController(Model model) {
  //      return "albums";
  //  }

}