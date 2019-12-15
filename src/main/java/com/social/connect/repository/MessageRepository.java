package com.social.connect.repository;


import com.social.connect.domain.Message;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface MessageRepository extends Neo4jRepository<Message, Long> {


    @Query("MATCH (p:Person)-[:SEND]-(m:Message)-[:SENT_TO]-(n:Person) return m ORDER BY m.date DESC LIMIT {0}")
    List<Message> lastDiscussions(Long limit);
    
}
