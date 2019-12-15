package com.social.connect.controller;


import com.social.connect.domain.Person;
import com.social.connect.services.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private FriendsService friendsService;

    @GetMapping("/profile")
    public Person profile(@RequestParam String username) {
        return friendsService.profile(username);
    }


    @GetMapping("/friends")
    public List<Person> fiends(@RequestParam String username) {
        return null;
    }

}
