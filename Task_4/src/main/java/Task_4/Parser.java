package Task_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Parser {
    public Scanner Load() throws FileNotFoundException;
    public ArrayList<String> Next(Scanner s, ArrayList<String> Array);
}
