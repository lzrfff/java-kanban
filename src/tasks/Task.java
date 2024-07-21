package tasks;
import status.Status;
import java.util.Scanner;
public class Task {

    protected int id;
    protected String title;
    protected String descript;
    protected Status status;

    public Task(int id, String title, String descript, Status statusTask) {
        this.id = id;
        this.title = title;
        this.descript = descript;
        this.status = statusTask;
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

    public void setStatusTask(Status statusTask) {
        this.status = statusTask;
    }

    @Override
    public String toString() {
        return "tasks.Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descript='" + descript + '\'' +
                ", statusTask='" + status + '\'' +
                '}';
    }


}