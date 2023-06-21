package Task_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserTXT implements Parser{
    static final String FILE_PATH = "C:\\SberPractice_2\\Task_4\\src\\main\\java\\Task_4";
    @Override
    public Scanner Load() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название файла (с расширением): ");
        String name = in.nextLine();
        File file =
                new File(FILE_PATH + "\\" + name);
        Scanner s = new Scanner(file);
        return s;
    }

    Boolean isOk = true;
    String str = "";
    @Override
    public ArrayList<String> Next(Scanner s, ArrayList<String> Array) {
        while (isOk) {
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
