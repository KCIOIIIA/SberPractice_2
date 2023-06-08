package Task_1;

public class QuitCommand implements Command {
    @Override
    public boolean exec(String[] arr) {
        if (arr.length == 1) {
            System.out.println("Встречена команда ВЫХОД");
            return false;
        } else {
            help();
            return true;
        }
    }

    @Override
    public void help() {
        System.out.println("Завершение ввода команд");
    }

    @Override
    public String getName() {
        return "quit";
    }

}
