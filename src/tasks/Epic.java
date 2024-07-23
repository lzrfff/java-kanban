package tasks;
import status.Status;
import tasks.Subtask;
import java.util.*;


public class Epic extends Task {
    protected ArrayList<Integer> subtaskIds = new ArrayList<>();;

    public Epic(int id, String title, String descript, Status statusTask, ArrayList<Integer> subtaskId) {
        super(id, title, descript, statusTask);
        this.subtaskIds= subtaskId;

    }

    public void removeSubtask(int id) {
        subtaskIds.clear();

    }

    public void addSubtaskId(int id) {
        subtaskIds.add(id);
    }




    public ArrayList<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void setSubtaskIds(ArrayList<Integer> subtaskIds) {
        this.subtaskIds = subtaskIds;
    }

    public int getId() {
        return id;
    }

    public String getDescript() {
        return descript;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatusTask() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescript(String descript) {
        this.descript = descript;

    }


    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", statusTask=" + status +'\'' +
                "subtaskIds=" + subtaskIds +
                '}' ;
    }


    public void cleanSubtaskIds() {
        subtaskIds.clear();

    }
}

