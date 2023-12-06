package org.example;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PotensPartneriEntity {
   private String regisNumber ;
    private String pol;
private String svedOsebe;
    private String registYear;
    private String trebovKpart;



    @Override
    public String toString() {
        return
                "Пол: " + pol+'\n'+
                "Регистрационный номер:  " + regisNumber + '\n' +
                        "Сведение о себе: "+svedOsebe+'\n'+
                "Дата регистрации: " + registYear +'\n'+
                "Требования к партнеру: " + trebovKpart + '\n';
    }
}
