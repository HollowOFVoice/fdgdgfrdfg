package org.example;

import lombok.Data;

import java.util.concurrent.Flow;
@Data
public class BookEntity {
   private String title ;
    private AuthorEntity author;
    private PublisherEntity publishing;
    private int year;
    private String kind;
}
