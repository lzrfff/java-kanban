import java.util.*;


public class Epic extends Task {
    protected ArrayList<Integer> subtaskIds = new ArrayList<>();;

    public Epic(int id, String title, String descript, Status statusTask, ArrayList<Integer> subtaskId) {
        super(id, title, descript, statusTask);
        this.subtaskIds=subtaskIds;
    }

    public ArrayList<Integer> addSubtaskId(int id){
        ArrayList<Integer> subtaskIds= new ArrayList<Integer>();

        return  subtaskIds;

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
        return statusTask;
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
    public void setStatusTask(Status statusTask) {
        super.setStatusTask(statusTask);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

