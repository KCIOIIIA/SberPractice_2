package Task_4;

import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Parser {
    private static final String FILE_PATH = "C:\\SberPractice_2\\Task_4\\src\\main\\java\\Task_4";
    public ArrayList<String> Array = new ArrayList();

    public void loader() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название файла (с расширением): ");
        String name = in.nextLine();
        File file =
                new File(FILE_PATH + "\\" + name);
        Scanner s = new Scanner(file);
        Next(s);
        new Analyzer().count(Array);
    }

    public ArrayList<String> Next(Scanner s){
        Boolean isOk = true;
        String str = "";
        while (isOk){
            if (s.hasNext()) {
                str = s.nextLine();
                String[] arr = str.split(" ");
                Array.addAll(List.of(arr));
            } else {
                isOk = false;
            }
        }
        return Array;
    }
}
