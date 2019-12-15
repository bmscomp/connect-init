package com.social.connect;

import com.social.connect.domain.Person;
import com.social.connect.domain.Picture;
import com.social.connect.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ConnectApplicationTests {


    @Autowired
    private PersonRepository personRepository;


    @Test
    void shouldFindSomePeople() {
        Person richard = personRepository.findByUsername("richard");
        Assertions.assertThat(richard).isNotNull();
        Assertions.assertThat(richard.getFriends()).isNotEmpty();
        Assertions.assertThat(richard.getFriends().size()).isEqualTo(2);
    }


    @Test
    void shouldFiendFriendsOfRichard() {
        List<Person> friendsOfRichard= personRepository.friendsOf("richard");
        Assertions.assertThat(friendsOfRichard).isNotEmpty();

        List<Person> friendsOfJames =  personRepository.friendsOf("james");
        Assertions.assertThat(friendsOfJames).isEmpty();

    }

    @Test
    @Disabled
    void shouldCreateANewPerson() {


        Picture avatar = new Picture();
        avatar.setDate(new Date());
        avatar.setUrl("some/url");

        Person james = new Person();
        james.setAvatar(avatar);
        james.setName("James");
        james.setUsername("james");

        Person savedJames = personRepository.save(james);

        Assertions.assertThat(savedJames).isNotNull();
        Assertions.assertThat(savedJames.getAvatar()).isNotNull();
        Assertions.assertThat(savedJames.getAvatar().getUrl()).isEqualTo("some/url");


        // Juste delete james.

    }

}
