package siri.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(int taskNo) {
        this.taskList.remove(taskNo - 1);
    }

    public void printTaskList() {
        for (int count = 0; count < taskList.size(); count++) {
            System.out.printf("    %d. %s%n", count + 1, this.taskList.get(count).getTaskString());
        }
    }

    public Task getTask(int taskNo) {
        return this.taskList.get(taskNo - 1);
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    public int getTaskCount() {
        return this.taskList.size();
    }
}
