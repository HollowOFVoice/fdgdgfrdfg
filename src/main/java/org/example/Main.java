package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;


public class  Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListPartnerov partner = new ListPartnerov();
        File file = new File("./file.txt");
        if(file.createNewFile()){
            System.out.println("Ваши данные будут записанны в файл");
        }else {
            System.out.println("Ваши данные уже существует");
        }
        try (FileReader fileReader = new FileReader(file)){
            Scanner fileScanner = new Scanner(fileReader);
            if(fileScanner.hasNextLine()){
                String str2 = fileScanner.nextLine();
                Gson gson = new Gson();
                partner = gson.fromJson(str2, ListPartnerov.class);
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
            System.out.println( "Добро пожайловать в наше бюро знакомств!" + "\n"+"сли" );
            switch (menu) {


                case 1: partner.getData().add(adddBook());break;
                case 2: allBooks(partner);break;
                case 3:
                    System.out.println("Чтобы удалить ");
                   delete(partner);
                    break;
                case 4:
                    searchMenu(partner);
                    break;

                case 5: {Gson gson = new Gson();
                    String str1 = gson.toJson(partner);
                    try(FileWriter fileWriter = new FileWriter(file)){
                        fileWriter.write(str1);
                        System.out.println("Данные успешно записанны! ");
                    }catch (IOException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("До свидание!");
                    System.out.println(
                            "\n" +
                                    "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬜⬜⬜⬛⬛⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬛⬜⬛⬜⬜⬛⬜⬛⬜⬛⬜⬛⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬛⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬛⬜⬛⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬛⬛⬜⬛⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬛⬛⬛⬜⬜⬜\n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬜⬛⬛⬛⬜⬛⬜⬜⬛⬜⬛⬛⬜⬜⬜⬜\n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬛⬜⬛⬜⬛⬜⬜⬜⬛⬜⬛⬛⬛⬜⬜⬜    \n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬜⬛⬜⬛⬜⬜⬛⬛⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬛⬜⬛⬜⬛⬜⬜⬜⬛⬜⬜⬛⬛⬜⬜\n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬜⬛⬜⬛⬜⬜⬛⬛⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬛⬛⬛⬜⬛⬜⬜⬜⬛⬜⬜⬛⬛⬜⬜\n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬛⬛⬜⬜⬜\n" +
                                    "⬜⬜⬜⬜⬛⬜⬜⬛⬛⬛⬜⬜⬜⬜⬜⬛⬛⬛⬛⬜⬜\n" +
                                    "⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬜⬜⬜⬜⬜ \n" +
                                    "⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜ \n" +
                                    "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ \n" +
                                    "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ \n" +
                                    "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ \n" +
                                    "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛\n");
                }
                break;
                default:;
                    System.out.println("Я начинаю догадываться, почему у тебя проблемы с отношениями (￣ε(#￣)");
            }

        } while (menu != 5);

    }


    public static void mainMenu() {
        System.out.println(
                "1 - Добавить потенциального жениха или невесту \n" +
                "2 - Вывести потенциальных женихов и невест \n" +
                "3 - удалить уже не таких потенциальных женихов и нивест\n" +
                "4 - поиск потенциального жениха или невесты\n" +
                "5 - Значит не судьба (((\n");

    }

    public static PotensPartneriEntity adddBook() {

        PotensPartneriEntity kodidatv = new PotensPartneriEntity();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите регистрационный номер: ");
        kodidatv.setRegisNumber(scanner.nextLine());

        System.out.println("Укажите  пол: ");
        kodidatv.setPol(scanner.nextLine());
        System.out.println("Введите дату регистрации: ");
kodidatv.setRegistYear(scanner.nextLine());
        System.out.println("Раскажите немного о себе: ");
        kodidatv.setSvedOsebe(scanner.nextLine());
        System.out.println("Укажите свои требования к партнеру: ");
        kodidatv.setTrebovKpart(scanner.nextLine());
        System.out.println("Кондидат был успешно добавлен! " + "\n");

        return kodidatv;

    }

    public static void allBooks(ListPartnerov partner) {
        int i = 1;
        int b = 0;
        for (PotensPartneriEntity bookaz : partner.getData()) {
            b++;
            System.out.println("Кондидат  №" + i++ + '\n' + bookaz.toString());
        }
    }

    public static PotensPartneriEntity searchMenu(ListPartnerov partner) {
        System.out.println("Введите данные для поиска кондидата: ");
        Scanner scanner = new Scanner(System.in);
        PotensPartneriEntity result = null;
        String textSearch;
        textSearch = scanner.nextLine();
        for (PotensPartneriEntity kondidat : partner.getData()) {
            if (kondidat.getPol().equals(textSearch) ||
                    kondidat.getRegisNumber().equals(textSearch) ||
                    kondidat.getRegistYear().equals(textSearch) ||
                    kondidat.getSvedOsebe().equals(textSearch) ||
                    kondidat.getTrebovKpart().indexOf(textSearch) > -1) {
                result = kondidat;
                break;
            }
        }
        System.out.println("Вот, что мне удалось найти:  \n" + result);
        return result;
    }

    public static void delete(ListPartnerov partner) {
        System.out.println("Введите данные для поиска кондидата: ");
        Scanner scanner = new Scanner(System.in);
        PotensPartneriEntity result = null;
        String textSearch;
        textSearch = scanner.nextLine();
        for (PotensPartneriEntity kondidat : partner.getData()) {
            if (kondidat.getPol().equals(textSearch) ||
                    kondidat.getRegisNumber().equals(textSearch) ||
                    kondidat.getRegistYear().equals(textSearch) ||
                    kondidat.getSvedOsebe().equals(textSearch) ||
                    kondidat.getTrebovKpart().indexOf(textSearch) > -1) {
                result = kondidat;
                break;
            }
        }
        System.out.println("Результат вашего поиска:  \n" + result+'\n'+"Чтобы удалить нажмите 1 и 2 для отмены");
        int b = scanner.nextInt();
        if (b==1) partner.getData().remove(result);
        memes();
    }

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
    // проверка коректности
    public static boolean phoneCorrect(String regDAta){
        return regDAta.matches("\\d{13}");
    }
    // проверка коректности
    public static boolean textCorrect(String text){
        return text.matches("[А-Я][а-я]{2,15}");
    }
    }


