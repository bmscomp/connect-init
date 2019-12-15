package com.social.connect.repository;

import com.social.connect.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByUsername(@Param("username") String username);

    @Query("MATCH (n:Person)-[:FRIEND]-(p:Person) WHERE n.username = {0} return p")
    List<Person> friendsOf(@Param("username") String username);
}
