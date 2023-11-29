package org.example;

import lombok.Data;
import lombok.Getter;

import java.util.concurrent.Flow;
@Data
@Getter
public class BookEntity {
   private String title ;
    private AuthorEntity authors;
    private PublisherEntity publishing;
    private String year;
    private String kind;
    private String id;


    @Override
    public String toString() {
        return
              "айди"+  id+'\n'+
        "Название книги: " + title + '\n' +
                "Автор книги: " + authors +'\n'+
                "Издатель книги: " + publishing +'\n'+
                "Год: " + year +'\n'+
                "Жанр: " + kind + '\n';
    }
}
