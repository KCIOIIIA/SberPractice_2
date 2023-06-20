package Task_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader implements Parser{
    static final String FILE_PATH = "C:\\SberPractice_2\\Task_4\\src\\main\\java\\Task_4";
    public ArrayList<String> Array = new ArrayList();
    public Loader() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название файла (с расширением): ");
        String name = in.nextLine();
        File file =
                new File(FILE_PATH + "\\" + name);
        Scanner s = new Scanner(file);
        //Next(s, Array);
        //new Analyzer().count(Array);
    }
}
