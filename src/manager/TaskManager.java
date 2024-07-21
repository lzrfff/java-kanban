package manager;
import status.Status;
import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import java.util.*;

public class TaskManager {

    private int generatorId = 0;
    private int fId;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();





    //Add-------------------------------------------
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
//=========================V====================================

//----------------------------------------------------------------
    //Поиск задачи по id----------------------------------
    public Task getTask(int id) { return tasks.get(id); }

    public Subtask getStask(int id) {
        return subtasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }
//================================V==========================================

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(this.tasks.values());
    }


    //Deleted-----------------------------------------------------
    public void deleteEpic(int id) {
        final Epic epic = epics.remove(id);
        for (Integer subtaskId : epic.getSubtaskIds()) {
            subtasks.remove(subtaskId);
        }
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }



    public void deleteSubtask(int id) {
        Subtask subtask = subtasks.remove(id);
        if (subtask == null) {
            return;
        }
        Epic epic = epics.get(subtask.getIdEpic());
        epic.removeSubtask(id);
        updateEpicStatus(epic.getId());
    }
    //================================V====================================

    //--Delete All------------------------------------------
    public void deleleAllTasks(){  //МЕтод удаления всех Таск
        tasks.clear();
    }

    public void deleleAllEpicks(){  //МЕтод удаления всех Таск
        epics.clear();
    }

    public void deleleAllSubtusk(){  //МЕтод удаления всех Таск
        subtasks.clear();
    }

    public  ArrayList<Subtask> getSubTasks() { ////4) Метода получения списка сабта

        ArrayList<Subtask> eSubTask = new ArrayList<>();
        if (epics.containsKey(fId)) {
            for (Subtask subtask : subtasks.values()) {
                if (subtask.getIdEpic() == fId) {
                    eSubTask.add(subtask);
                }
            }
        }
        return new ArrayList<>();
    }





   //====================================V=================================

    ///Update----------------------------------------------

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


    public void updateEpic(Epic epic) {
        final Epic savedEpic = epics.get(epic.getId());
        savedEpic.setTitle(epic.getTitle()); //
        savedEpic.setDescript(epic.getDescript());
    }

    public void updateTask(Task task) {
        final int id = task.getId();
        final Task savedTask = tasks.get(id);
        if (savedTask == null) {
            return;
        }
        tasks.put(id, task);
    }



    public void updateSubtask(Subtask subtask) {
        int id = subtask.getId();
        int epicId = subtask.getIdEpic();
        Subtask savedSubtask = subtasks.get(id);
        if (savedSubtask == null) {
            return;
        }
        Epic epic = epics.get(epicId);
        if (epic == null) {
            return;
        }
        subtasks.put(id, subtask);
        updateEpicStatus(epicId);
    }

}
//------------------------------V------------------------