import java.util.*;

public class TaskMahager {

    Scanner scanner = new Scanner(System.in);

    int nextId = 0;
    HashMap<Integer, Task> SimplTasks = new HashMap<>();
    HashMap<Integer, Epic> Epics = new HashMap<>();
    HashMap<Integer, Subtask> SubTasks = new HashMap<>();


    // ArrayList<Task>
    // ArrayList<Epic>
    // ArrayList<SubTask>


    public void addSimple(Task task) {

        nextId++;
        SimplTasks.put(nextId, task);
    }

    public void addiEpic(Epic epic) {
        nextId++;
        Epics.put(nextId, epic);
    }

    public void addSubtask(Subtask subtask) {
        nextId++;
        SubTasks.put(nextId, subtask);
    }

    public void printHashSTask() {
        System.out.println("   Tasks   *");
        for (Integer id : SimplTasks.keySet()) {
            Integer key = id.intValue();
            String value = SimplTasks.get(key).toString();
            System.out.println(key + "--->" + value);
        }
    }

    public void printHashETask() {
        System.out.println("   Epics   *");
        for (Integer id : Epics.keySet()) {
            Integer key = id.intValue();
            String value = Epics.get(key).toString();
            System.out.println(key + "--->" + value);
        }
    }

    public void printHashSubTask() {
        System.out.println("   SubTasks   *");
        for (Integer id : SubTasks.keySet()) {
            Integer key = id.intValue();
            String value = SubTasks.get(key).toString();
            System.out.println(key + "--->" + value);
        }
    }


    public void ClearHashSTask() {
        SimplTasks.clear();
    }

    //h.remove("n1");
    public void DeleteNItem() {
        System.out.println("Введите тип задачи для Удаления элемента: T-Task; E-Epic; S-Subtask ");
        String command = scanner.nextLine();
        switch (command) {
            case "T":
                System.out.println("Введите ID елемента Task");
                int delId = scanner.nextInt();
                if (SimplTasks.containsKey(delId)) {
                    SimplTasks.remove(delId);
                } else {
                    System.out.println("В задачах Task элемента с таким ID Нет");
                }

                break;
            case "E":
                System.out.println("Введите ID елемента Epic");
                delId = scanner.nextInt();
                if (Epics.containsKey(delId)) {
                    Epics.remove(delId);
                } else {
                    System.out.println("В задачах Task элемента с таким ID Нет");
                }
                break;
            case "S":
                System.out.println("Введите ID елемента SubTask");
                delId = scanner.nextInt();
                if (SubTasks.containsKey(delId)) {
                    SubTasks.remove(delId);
                } else {
                    System.out.println("В задачах Task элемента с таким ID Нет");
                }
                break;
        }
    }

    public void FindNItem() {
        System.out.println("Введите тип задачи Для поиска элемента: T-Task; E-Epic; S-Subtask ");
        String command = scanner.nextLine();
        switch (command) {
            case "T":
                System.out.println("Введите ID елемента Task");
                int fId = scanner.nextInt();
                if (SimplTasks.containsKey(fId)) {
                    System.out.println(SubTasks.get(fId));
                } else {
                    System.out.println("В задачах Task элемента с таким ID Нет");
                }

                break;
            case "E":
                System.out.println("Введите ID елемента Epic");
                fId = scanner.nextInt();
                if (Epics.containsKey(fId)) {
                    System.out.println(Epics.get(fId));
                } else {
                    System.out.println("В задачах Task элемента с таким ID Нет");
                }
                break;
            case "S":
                System.out.println("Введите ID елемента SubTask");
                fId = scanner.nextInt();
                if (SubTasks.containsKey(fId)) {
                    System.out.println(SubTasks.get(fId));
                } else {
                    System.out.println("В задачах Task элемента с таким ID Нет");
                }
                break;
        }
    }


    public void printEpSubtask() {

        ArrayList<Task> eSubTask = new ArrayList<>();
        System.out.println("Введите ID елемента Epic");
        Integer fId = scanner.nextInt();
        if (Epics.containsKey(fId)) {
            System.out.println("Epic c данным номером;" + Epics.get(fId));
            System.out.println("SubTasks for Epic" + fId);
            for (Subtask subtask : SubTasks.values()) {
                if (subtask.getIdEpic() == fId) {
                    eSubTask.add(subtask);
                }
            }
            for (int i = 0; i < eSubTask.size(); i++) {
                System.out.println(eSubTask.get(i));
            }

            //System.out.println(eSubTask);
        }
    }


    private void updateEpicStatus(int epicId) {
        Epic epic = Epics.get(epicId);
        ArrayList<Integer> subs = epic.getIdStask();
        if (subs.isEmpty()) {
            epic.setStatusTask(Status.NEW);
            return;
        }
        String status = null;
        for (int id : subs) {
            final Subtask subtask = SubTasks.get(id);
            if (status == null) {
                status = String.valueOf(subtask.getStatusTask());
                continue;
            }

            if (status.equals(subtask.getStatusTask())
                    && !status.equals(Status.IN_PROGRESS)) {
                continue;
            }
            epic.setStatusTask(Status.IN_PROGRESS);
            return;
        }
        epic.setStatusTask(Status.DONE);
    }
}
