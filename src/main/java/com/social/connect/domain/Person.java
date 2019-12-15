package com.social.connect.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@Data
@NodeEntity
@EqualsAndHashCode(exclude = {"friends", "avatar"})
public class Person {

    @GeneratedValue
    @Id
    private Long id;
    @Index(unique = true)
    private String username;
    private String name;

    @Relationship(type = "AVATAR")
    private Picture avatar;

    @Relationship(type = "FRIEND", direction = Relationship.UNDIRECTED)
    private Set<Person> friends;

}
