package org.example;

import lombok.Data;

import java.util.concurrent.Flow;
@Data
public class BookEntity {
   private String title ;
    private AuthorEntity authors;
    private PublisherEntity publishing;
    private int year;
    private String kind;

    @Override
    public String toString() {
        return
        "Название книги: " + title + '\n' +
                "Автор книги: " + authors +'\n'+
                "Издатель книги: " + publishing +'\n'+
                "Год: " + year +'\n'+
                "Жанр: " + kind + '\n';
    }
}
