package Task_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommand implements Command{
        @Override
        public boolean exec(String[] arr) {
            Date date = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
            System.out.println(formater.format(date));
            return true;
        }

        @Override
        public void help() {
            System.out.println("Вывод текущей даты");
        }

        @Override
        public String getName() {
            return "date";
        }
}
