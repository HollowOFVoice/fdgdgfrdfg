package org.example;

import lombok.Data;

@Data
public class AuthorEntity {
    private String name;
    private  String lastname;//otchestvo
    private String surname;


    @Override
    public String toString() {
        return
                 name +"   " + surname + "   " + lastname;
    }
}
