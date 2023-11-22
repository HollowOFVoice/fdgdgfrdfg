package org.example;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int menu = 0;
        do {
            mainMenu();
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    ;
                    break;
                case 2:
                    ;
                    break;
                case 3:
                    ;
                    break;
                case 4:
                    ;
                    break;
                case 5:
                    System.out.println("Попутного ветра");
                    break;
            }
        } while (menu != 5);

    }


    public static void mainMenu() {
        System.out.println("Выберите нужное действие: \n" +
                "1 - Добавить \n" +
                "2 - Вывести \n" +
                "3 - удалить \n" +
                "4 - поиск\n" +
                "5 - закрыть программу\n");

    }

    public static String aDd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилию Автора: ");
        AuthorEntity author = new AuthorEntity();
        author.setName(scanner.nextLine());
        System.out.println("Введите Имя Автора: ");
        System.out.println("Введите отчество автора");
        PublisherEntity publisher =new PublisherEntity();
        System.out.println("Введите название издательства");

        return null;
    }

}

/*
do {

        Menu.mainMenu();
        menu = scanner.nextByte();
        switch (menu){
        case (1): baza.add(Menu.painADDMenu());break;
        case (2):Menu.printMenu(baza);break;
        case (3): System.out.println("Укажите данные для поиска: \n");
        System.out.println( Menu.searchMenu(baza));
        if (Menu.searchMenu(baza)==null) break;
        System.out.println("Если хотите удалить заказ? Нажмите 1 либо же 2 чтобы отменить удаление");
        int a =1, b=2;
        int bov = scanner.nextInt();
        if (bov==1) {System.out.println("Успешно удалено \n"); baza.remove(Menu.searchMenu(baza));}
        else System.out.println("Удаление отклонено \n") ;break;

        case (4): System.out.println("Введите данные для поиска: \n");
        System.out.println( Menu.searchMenu(baza));break;
        case (5): System.out.println("Досвидания");break;
default:System.out.println("Дурочок совсем? ಠ_ಠ? ಠ_ಠ? ಠ_ಠ? \n");
        }
        }while (menu !=5);

        }
        }*/