package com.example.controller;

import com.example.task_5.Album;
import com.example.task_5.Group;
import com.example.task_5.Track;
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
        groups.add(new Group("Arctic Monkeys", "2",
                List.of(new Album("AM", "21", "2013",
                                List.of(new Track("Do I Wanna Know?", "211", "4:32"),
                                        new Track("R U Mine?", "212", "3:21"),
                                        new Track("I Wanna Be Yours", "213", "3:03"),
                                        new Track("Knee Socks", "214", "4:17"))),
                        new Album("Whatever People Say I Am, That's What I'm Not", "22", "2006",
                                List.of(new Track("When The Sun Goes Down", "221", "3:20"))),
                        new Album("Favourite Worst Nightmare", "23", "2007",
                                List.of(new Track("505", "231", "4:13"),
                                        new Track("Only Ones Who Know", "232", "3:04"))))));
        groups.add(new Group("Nirvana", "1",
                List.of(new Album("Nevermind", "11", "1991",
                                List.of(new Track("Smells Like Teen Spirit", "111", "5:01"),
                                        new Track("Come As You Are", "112", "3:38"))),
                        new Album("Nirvana", "12", "2002",
                                List.of(new Track("You Know You're Right", "121", "3:37")))))
        );
        model.addAttribute("groups", groups);
        return "groups";
    }

    // @RequestMapping(value = "/groups/${group.id}/albums")
   // public String albumsController(Model model) {
  //      return "albums";
  //  }

}