package com.social.connect.services;

import com.social.connect.domain.Person;
import com.social.connect.domain.Picture;
import com.social.connect.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FriendsService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(@NotNull String username, String name, String avatarUrl) {

        Person person = new Person();
        person.setUsername(username);
        person.setName(name);

        Picture picture = new Picture();
        picture.setDate(new Date());
        picture.setUrl(avatarUrl);

        return personRepository.save(person);
    }


    public Person profile(String username) {
        return personRepository.findByUsername(username);
    }

    public List<Person> friends(String username) {
        return personRepository.friendsOf(username);
    }

}
