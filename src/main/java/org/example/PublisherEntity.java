package org.example;

import lombok.Data;

@Data
public class PublisherEntity {

    private String namePublisher;
   private String cityPublisher;


    @Override
    public String toString() {
        return
                 namePublisher + ".    Город издателя:    " + cityPublisher;
    }

}
