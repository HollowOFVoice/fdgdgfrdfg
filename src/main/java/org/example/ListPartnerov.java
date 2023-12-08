package org.example;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
public class ListPartnerov {
    private List<PotensPartneriEntity> data;

//
    public ListPartnerov() {
        this.data = new ArrayList<>();
    }
}

