package com.social.connect.repository;

import com.social.connect.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByUsername(@Param("username") String username);
}
