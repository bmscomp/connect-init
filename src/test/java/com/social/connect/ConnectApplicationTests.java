package com.social.connect;

import com.social.connect.domain.Person;
import com.social.connect.repository.PersonRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConnectApplicationTests {


    @Autowired
    private PersonRepository personRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void shouldFindSomePeople() {
        Person richard  = personRepository.findByUsername("richard");
        Assertions.assertThat(richard).isNotNull();
        Assertions.assertThat(richard.getFriends()).isNotEmpty();
        Assertions.assertThat(richard.getFriends().size()).isEqualTo(2);
        System.out.println("Please find some people ");
    }

}
