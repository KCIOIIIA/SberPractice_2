package Task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Next implements Parser{
    Boolean isOk = true;
    String str = "";

    public Next(Scanner s, ArrayList<String> Array) {
        while (isOk) {
            if (s.hasNext()) {
                str = s.nextLine();
                String[] arr = str.split(" ");
                Array.addAll(List.of(arr));
            } else {
                isOk = false;
            }
        }
    }
}
