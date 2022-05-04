package api.atlantis.domain.app.planning;

import api.atlantis.domain.sp.TaskForHome;

import javax.persistence.*;

@Embeddable
public class Task {
    private String taskName;
    private int taskStatus;

    public Task() {
    }

    public Task(String taskName, int taskStatus) {
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }
}
