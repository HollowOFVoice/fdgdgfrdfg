package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;


public class  Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListBook masBook = new ListBook();
        File file = new File("./file.txt");
        if(file.createNewFile()){
            System.out.println("Файл успешно был создан");
        }else {
            System.out.println("Файл уже существует");
        }
        try (FileReader fileReader = new FileReader(file)){
            Scanner fileScanner = new Scanner(fileReader);
            if(fileScanner.hasNextLine()){
                String str2 = fileScanner.nextLine();
                Gson gson = new Gson();
                masBook = gson.fromJson(str2, ListBook.class);
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден ");}catch (IOException e){

            throw new RuntimeException(e);
        }
        int menu = 0;

        do {
            try{

            mainMenu();
                String S= scanner.nextLine();;
                menu = Integer.parseInt(S);
        }catch (Exception e){
                System.out.println("Введено не число");
            }
            switch (menu) {

               /* case 0: {Gson gson = new Gson();
                String str1 = gson.toJson(masBook);
                try(FileWriter fileWriter = new FileWriter(file)){
                    fileWriter.write(str1);
                    System.out.println("Данные успешно созранены в файл ");
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                    System.out.println("До свидание!");
                }
                break;*/
                case 1:
                    masBook.getData().add(adddBook());
                    break;
                case 2:
                    allBooks(masBook);
                    break;
                case 3:
                    System.out.println("Чтобы удалить ");

                   delete(masBook);

//fgkjfdg
                    break;
                case 4:
                    searchMenu(masBook);
                    break;

                case 5: {Gson gson = new Gson();
                    String str1 = gson.toJson(masBook);
                    try(FileWriter fileWriter = new FileWriter(file)){
                        fileWriter.write(str1);
                        System.out.println("Данные успешно созранены в файл ");
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("До свидание!");
                    System.out.println("／ﾌﾌ 　　　　　　 　ム｀ヽ\n" +
                            "/ ノ) 　 ）　ヽ\n" +
                            "/ ｜　　( ͡° ͜ʖ ͡°）ノ⌒（ゝ._,ノ\n" +
                            "/　ﾉ⌒7⌒ヽーく　 ＼　／\n" +
                            "丶＿ ノ ｡　　 ノ､　｡|/\n" +
                            "　　 `ヽ `ー-'_人`ーﾉ\n" +
                            "　　　 丶 ￣ _人'彡");
                }
                break;
                default:;
                    System.out.println("／ﾌﾌ 　　　　　　 　ム｀ヽ\n" +
                            "/ ノ) 　 ）　ヽ\n" +
                            "/ ｜　　( ͡° ͜ʖ ͡°）ノ⌒（ゝ._,ノ\n" +
                            "/　ﾉ⌒7⌒ヽーく　 ＼　／\n" +
                            "丶＿ ノ ｡　　 ノ､　｡|/\n" +
                            "　　 `ヽ `ー-'_人`ーﾉ\n" +
                            "　　　 丶 ￣ _人'彡");
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

    public static BookEntity adddBook() {

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
        book.setYear(scanner.nextLine());
        System.out.println("Укажите жанр книги:");
        book.setKind(scanner.next());
        System.out.println("Молодой жаб, ваша книга успешна добавлена! " + "\n");

        return book;

    }

    public static void allBooks(ListBook masBook) {


        int i = 1;
        int b = 0;
        for (BookEntity bookaz : masBook.getData()) {
            b++;
            System.out.println("Книга №" + i++ + '\n' + bookaz.toString());


        }
    }

    public static BookEntity searchMenu(ListBook masBook) {
        System.out.println("Введите данные для поиска книги: ");
        Scanner scanner = new Scanner(System.in);
        BookEntity result = null;
        String textSearch;
        textSearch = scanner.nextLine();
        for (BookEntity kniga : masBook.getData()) {
            if (kniga.getAuthors().equals(textSearch) ||
                    kniga.getPublishing().equals(textSearch) ||
                    kniga.getKind().equals(textSearch) ||
                    kniga.getYear().equals(textSearch) ||
                    kniga.getTitle().indexOf(textSearch) > -1) {
                result = kniga;
                break;
            }
        }
        System.out.println("Вот, что мне удалось найти:  \n" + result);
        return result;
    }
///hgg
    public static void delete(ListBook masBook) {
        System.out.println("Введите данные для поиска книги: ");
        Scanner scanner = new Scanner(System.in);
        BookEntity result = null;
        String textSearch;
        textSearch = scanner.nextLine();
        for (BookEntity kniga : masBook.getData()) {
            if (kniga.getAuthors().equals(textSearch) ||
                    kniga.getPublishing().equals(textSearch) ||
                    kniga.getKind().equals(textSearch) ||
                    kniga.getYear().equals(textSearch) ||
                    kniga.getTitle().indexOf(textSearch) > -1) {
                result = kniga;
                break;
            }
        }

        System.out.println("Результат вашего поиска:  \n" + result+'\n'+"Чтобы удалить нажмите 1 и 2 для отмены");
        int b = scanner.nextInt();
        if (b==1) masBook.getData().remove(result);
        memes();
    }


   /* public static void delll(ListBook masBook) {


        int i = 1;
        int b = 0;
        for (BookEntity bookaz : masBook.getData()) {
            b++;
            System.out.println("Книга №" + i++ + '\n' + bookaz.toString());
            bookaz.setId(String.valueOf(b));
        }
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер книги, которую хотите удалить: ");
            BookEntity result = null;
            String textSearch;
            textSearch = scanner.nextLine();
            for (BookEntity kniga : masBook.getData()) {
                if (kniga.getId().equals(textSearch) ||
                        kniga.getTitle().indexOf(textSearch) > -1) {

                    masBook.getData().remove(kniga);
                    System.out.println("Информация о книге удалена:  \n");

   *//* String b;
    b = scanner.nextLine();

    for (BookEntity boka: masBook.getData()) {
        if (boka.getId().equals(b))
      masBook.getData().remove(boka);*//*


                }
            }
        }*/

    public static void memes(){
       System.out.println(".\n" +
               "______________88¶¶¶¶¶¶¶8¶8881________________\n" +
               "___________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶8____________\n" +
               "_________8¶¶¶8______18¶¶¶¶¶¶¶¶¶¶¶¶¶1_________\n" +
               "________8¶¶______________88¶¶¶¶¶¶¶¶¶¶________\n" +
               "_______8¶___________________1¶¶¶¶¶¶¶¶¶8______\n" +
               "_______¶_______________________8¶¶¶¶¶¶¶¶_____\n" +
               "______8¶¶¶¶8_____________________8¶¶¶¶¶¶¶____\n" +
               "_____1____¶¶¶_____________________8¶¶¶¶¶¶¶___\n" +
               "____1¶______¶______________________¶¶¶¶¶¶¶¶__\n" +
               "____¶_888_8________¶¶¶¶¶¶8________8¶¶¶¶¶¶¶¶¶_\n" +
               "____8_¶¶¶118____________8¶¶_______¶¶¶¶¶¶¶¶¶¶1\n" +
               "___¶___181_8__1___11111___88_____¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "__¶_______¶1__¶__¶¶8¶¶_¶________1¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "_¶1_____1¶___¶8____¶¶¶_¶¶_______8¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "_¶____1______¶8_________________¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "_¶____8_______8¶________________¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "_8_18______1___¶_______________8¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "_1_¶__________________________1¶¶¶1__¶¶¶¶¶¶¶8\n" +
               "88____________________________¶8____88¶¶¶¶¶¶_\n" +
               "¶8___¶81_________________________1__1¶¶¶¶¶¶__\n" +
               "¶8___¶¶881118___88_______________1811¶¶¶¶¶1__\n" +
               "¶¶____¶¶¶¶¶¶¶¶8________________11¶81¶¶¶¶¶¶8¶8\n" +
               "¶¶_____8¶¶888________________¶____8¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶___________________________1_¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶____________________________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶___¶_________________¶1____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶__________________8¶¶____1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶8_______________1¶1____¶8_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶¶¶¶11___1____________8¶__8¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶¶¶¶__¶¶11__________¶¶1___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶¶¶¶8__81_________18_____8¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "¶___________________________________________¶\n" +
               "¶______________¶¶¶____¶¶¶¶__________________¶\n" +
               "¶_____________¶¶_¶¶__¶¶__¶¶_________________¶\n" +
               "¶_____________¶¶_¶¶__¶¶¶¶¶¶_________________¶\n" +
               "¶____________¶¶¶¶¶¶¶_¶¶__¶¶_________________¶\n" +
               "¶____________¶_____¶_¶¶__¶¶_________________¶\n" +
               "¶___________________________________________¶\n" +
               "¶____¶¶¶__¶¶¶¶____¶¶¶___¶¶__¶¶__¶¶¶¶____¶¶¶_¶\n" +
               "¶___¶_¶¶_¶¶__¶¶__¶¶_¶¶__¶¶__¶¶_¶¶__¶¶___¶¶¶_¶\n" +
               "¶__¶__¶¶_¶¶¶¶¶¶__¶¶_¶¶__¶¶¶¶¶¶_¶¶__¶¶___¶¶¶_¶\n" +
               "¶_¶¶__¶¶_¶¶__¶¶_¶¶¶¶¶¶¶_¶¶__¶¶_¶¶__¶¶_______¶\n" +
               "¶_¶¶__¶¶_¶¶__¶¶_¶_____¶_¶¶__¶¶__¶¶¶¶____¶¶¶_¶\n" +
               "¶___________________________________________¶\n" +
               "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
               "\n" );
   }
    }


