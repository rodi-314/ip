package siri.tasks;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(int taskNo) {
        this.taskList.remove(taskNo - 1);
    }

    public void printTaskList() {
        for (int count = 0; count < taskList.size(); count++) {
            System.out.printf("     %d. %s%n", count + 1, this.taskList.get(count).getTaskString());
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

    public void printFindTasks(String description) {
        int foundCount = 1;
        for (Task task : this.taskList) {
            if (task.getDescription().contains(description)) {
                System.out.printf("    %d. %s%n", foundCount, task.getTaskString());
                foundCount++;
            }
        }
    }
}
