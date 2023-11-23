package org.example;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList masBook = new ArrayList<>();
        int menu = 0;
        do {
            mainMenu();
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    masBook.add(adddBook());
                    break;
                case 2:

                    allBooks(masBook); break;
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

    public static String adddBook() {

        BookEntity book = new BookEntity();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги");
        book.setTitle(scanner.nextLine());
        System.out.println("Введите имя автора книги:");

        AuthorEntity avtor = new AuthorEntity();

        avtor.setName(scanner.nextLine());
        System.out.println("Введите фамилию автора книги:");
        avtor.setSurname(scanner.nextLine());
        System.out.println("Введите отчество автора книги:");
        avtor.setLastname(scanner.nextLine());
        book.setAuthors(avtor);

        PublisherEntity publika = new PublisherEntity();

        System.out.println("Укажите имя издательства");
        publika.setNamePublisher(scanner.nextLine());
        System.out.println("Укажите город издательства");
        publika.setCityPublisher(scanner.nextLine());
        book.setPublishing(publika);
        System.out.println("Укажите год публикации:");
        book.setYear(scanner.nextInt());
        System.out.println("Укажите жанр книги:");
        book.setKind(scanner.nextLine());
        System.out.println("Молодой жаб, ваша книга успешна добавлена! "+"\n");
        return String.valueOf(book);
    }

    public static void allBooks(ArrayList masBook) {


            int i = 1;
            for (Object bookaz : masBook) {

                System.out.println("Книга №" + i++ + '\n' + bookaz.toString());
            }
        }
    }






