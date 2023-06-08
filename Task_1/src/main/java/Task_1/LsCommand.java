package Task_1;

import java.io.File;
public class LsCommand implements Command {
    private static final String FILE_PATH = "C:\\SberPractice_2\\Task_1\\src\\main\\java\\Task_1";
    @Override
    public boolean exec(String[] arr) {
        if (arr.length == 1) {
            File directory = new File(FILE_PATH);
            File[] files = directory.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {help();}
        return true;
    }

    @Override
    public void help() {
        System.out.println("Вывод содержимого текущего каталога");
    }

    @Override
    public String getName() {
        return "ls";
    }
}
