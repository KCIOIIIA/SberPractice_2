package Task_1;

public class QuitCommand implements Command {
    @Override
    public boolean exec(String[] arr) {
        return false;
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
