import java.util.Scanner;

public class Main {
    static TaskManager manager = new TaskManager();
    //Task task=new Task();


    public static void main(String[] args) {
        Status status;
        Task task1 = new Task(1, "Task Buy dollar", "Cash", Status.NEW);
        Task task2 = new Task(2, "Task Buy Euro", "Stock", Status.DONE);
        Task task3 = new Task(3, "Task Buy CHY", "Carrency", Status.IN_PROGRESS);


       // Epic epic1 = new Epic(4, "Epik1", "Buy Car", Status.NEW, 1);
       // Epic epic2 = new Epic(5, "Epik2", "Buy Refregerator", Status.NEW, 1);

        Subtask subtask1 = new Subtask(1, "Subtask", "Transfer money", Status.NEW, 4);
        Subtask subtask2 = new Subtask(2, "Subtask", "Convert money", Status.NEW, 4);
        Subtask subtask3 = new Subtask(3, "Subtask", "Sell OldCar", Status.DONE, 4);

        Subtask subtask4 = new Subtask(4, "Subtask", "Recive Salary", Status.DONE, 5);
        Subtask subtask5 = new Subtask(5, "Subtask", "Cash money", Status.DONE, 5);

        System.out.println(subtask1.getIdEpic());


        manager.addSimple(task1);
        manager.addSimple(task2);
        manager.addSimple(task3);
      //  manager.addiEpic(epic1);
      //  manager.addiEpic(epic2);


        //a. Получение списка всех задач.
    }
}