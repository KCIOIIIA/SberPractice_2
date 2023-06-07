package Task_1;
import java.io.File;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Main {
    private static final String FILE_PATH = "C:\\SberPractice_2\\Task_1\\src\\main\\java\\Task_1";
    public static void main(String[] args) {
        File directory = new File(FILE_PATH);
        File[] files = directory.listFiles();
        String s2 = "quit";
        String s1 = "";
        while ((s1.equals(s2)) == false) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите команду: ");
            String com = in.nextLine();
            String[] words = com.split(" ");
            if (words[0].equals("date")) {
                if (words.length == 1){
                    Date date = new Date();
                    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println(formater.format(date));
                }
                else if (words[0].equals("-h")){
                    System.out.println("Вывод текущей даты");
                }
                else {
                    System.out.println("Недопустимая команда!");
                }
            }
            else if (words[0].equals("time")) {
                if (words.length == 1){
                    Date date = new Date();
                    SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
                    System.out.println(formater.format(date));
                }
                else if (words[0].equals("-h")){
                    System.out.println("Вывод текущего времени");
                }
                else {
                    System.out.println("Недопустимая команда!");
                }
            }
            else if (words[0].equals("ls")) {
                if (words.length == 1){
                    for (File file : files) {
                        System.out.println(file.getName());
                    }
                }
                else if (words[0].equals("-h")){
                    System.out.println("Вывод текущего каталога");
                }
                else {
                    System.out.println("Недопустимая команда!");
                }
            } else if (words[0].equals("quit")) {
                if (words.length == 1){
                    s1 = words[0];
                    in.close();
                }
                else if (words[0].equals("-h")){
                    System.out.println("Завершение ввода команд");
                }
                else {
                    System.out.println("Недопустимая команда!");
                }
            } else if (words[0].equals("help")) {
                if (words.length == 1){
                    System.out.println("date - Вывод текущей даты");
                    System.out.println("time - Вывод текущего времени");
                    System.out.println("ls - Вывод текущего каталога");
                    System.out.println("quit - Завершение ввода команд");
                }
                else {
                    System.out.println("Недопустимая команда!");
                }
            } else {
                System.out.println("Недопустимая команда!");
            }
        }
        System.out.println("Встречена команда ВЫХОД");
    }
}