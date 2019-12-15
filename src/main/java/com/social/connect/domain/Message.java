package com.social.connect.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.time.LocalDate;
import java.util.Date;

@Data
@NodeEntity(label = "Message")
public class Message {

    @GeneratedValue
    @Id
    private Long id;
    private String content;
    @DateLong
    private Date send;

}
