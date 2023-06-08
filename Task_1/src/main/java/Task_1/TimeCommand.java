package Task_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCommand implements Command {
    @Override
    public boolean exec(String[] arr) {
        if (arr.length == 1){
            Date date = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
            System.out.println(formater.format(date));
        }
        else {help();}
        return true;
    }

    @Override
    public void help() {
        System.out.println("Вывод текущего времени");
    }

    @Override
    public String getName() {
        return "time";
    }
}
