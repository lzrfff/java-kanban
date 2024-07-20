import java.util.*;

public class TaskManager {



    int generatorId= 0;
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();


    public Integer addSimple(Task task) {
        int id = ++generatorId;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public int addiEpic(Epic epic) {
        int id = ++generatorId;
        epic.setId(id);
        epics.put(id, epic);
        return id;
    }







    public Integer addNewSubtask(Subtask subtask) {
            int epicId = subtask.getIdEpic();
            Epic epic = epics.get(epicId);
            if (epic == null) {
                return null;
            }
            int id = ++generatorId;
            subtask.setId(id);
            subtasks.put(id, subtask);
            epic.addSubtaskId(subtask.getId());
            updateEpicStatus(epicId);
            return id;
    }



//----------------------------------------------------------------
 //*****
//*****

    public void updateTask(Task task) {
        final int id = task.getId();
        final Task savedTask = tasks.get(id);
        if (savedTask == null) {
            return;
        }
        tasks.put(id, task);
    }

    public void updateSubtask(Subtask subtask) {
        final int id = subtask.getId();
        final Subtask savedSubtask = subtasks.get(id);
        if (savedSubtask == null) {
            return;
        }
        tasks.put(id, subtask);
    }

    public void updateEpic(Epic epic) {
        final int id = epic.getId();
        final Epic savedEpic = epics.get(id);
        if (savedEpic == null) {
            return;
        }
        tasks.put(id, epic);
    }




//Поиск задачи по id
    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Subtask getStask(int id) {
        return subtasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }
//============================================

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(this.tasks.values());
    }


    public void deleteEpic(int id) {
        final Epic epic = epics.remove(id);
        for (Integer subtaskId : epic.getSubtaskIds()) {
            subtasks.remove(subtaskId);
        }
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void deleteSubTask(int id) {
        subtasks.remove(id);
    }




    private void updateEpicStatus(int epicId) {
        Epic epic = epics.get(epicId);
        ArrayList<Integer> subs = epic.getSubtaskIds();
        if (subs.isEmpty()) {
            epic.setStatusTask(Status.NEW);
            return;
        }
        String status = null;
        for (int id : subs) {
            final Subtask subtask = subtasks.get(id);
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
