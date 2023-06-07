package Task_1;

public class HelpCommand implements Command {
    @Override
    public boolean exec(String[] arr) {
        System.out.println("date - Вывод текущей даты");
        System.out.println("time - Вывод текущего времени");
        System.out.println("ls - Вывод текущего каталога");
        System.out.println("quit - Завершение ввода команд");
        return true;
    }

    @Override
    public void help() {
        System.out.println("Вывод описаний команд");
    }

    @Override
    public String getName() {
        return "help";
    }
}
