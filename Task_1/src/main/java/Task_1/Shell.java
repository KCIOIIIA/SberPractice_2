package Task_1;
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Shell {
    private static final String FILE_PATH = "C:\\SberPractice_2\\Task_1\\src\\main\\java\\Task_1";
    List <Command> cmd = new ArrayList<>();
    public Shell(){
        cmd.add(new DateCommand());
        cmd.add(new TimeCommand());
        cmd.add(new LsCommand());
        cmd.add(new QuitCommand());
        cmd.add(new HelpCommand());
    }

    private void run() {
        boolean result = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите команду: ");
            String com = in.nextLine();
            String[] words = com.split(" ");
            for (int i = 0; i < 5; i++) {
                if (words[0].equals(cmd.get(i).getName())) {
                    result = cmd.get(i).exec(words);
                }
            }
        }
        while (result);
    }
    public static void main(String[] args) {
        new Shell().run();
    }
}