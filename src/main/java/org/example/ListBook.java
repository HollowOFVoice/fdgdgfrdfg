package org.example;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
public class ListBook {
    private List<BookEntity> data;


    public ListBook() {
        this.data = new ArrayList<>();
    }
}

