package Task_1;
public interface Command {
    boolean exec(String [] arr);   //выполнение необходимого функционала
    void help();                //вызов справки о команде
    String getName();           //имя команды
}
