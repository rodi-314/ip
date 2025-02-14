package siri.tasks;

public class Task {
    protected String description;
    protected boolean isDone;
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    public void setStatus(boolean isDone) {
        this.isDone = isDone;
    }
    public String getTaskString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}