package Task_4;

import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportBuilder {
    private static final String FILE_PATH = "C:\\SberPractice_2\\Task_4\\src\\main\\java\\Task_4";

    @Bean
    public void Print(ArrayList arr){

        Scanner in = new Scanner(System.in);
        System.out.println("Введите название выходного файла (с расширением): ");
        String name = in.nextLine();
        File file =
                new File(FILE_PATH + "\\" + name);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bf = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bf))
        {
            int i = 0;
            while (i < arr.size()){
                out.println(arr.get(i) + "   " + arr.get(i + 1));
                i = i + 2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
