package siri.tasks;

public class TaskList {
    private Task[] taskList;
    private int taskCount = 0;

    public TaskList() {
        this.taskList = new Task[100];
    }

    public void addTask(Task task) {
        this.taskList[taskCount] = task;
        this.taskCount++;
    }

    public void removeTask(int taskNo) {
        for (int count = taskNo - 1; count < taskCount - 1; count++) {
            taskList[count] = taskList[count + 1];
        }
        taskCount--;
    }

    public void printTaskList() {
        for (int count = 0; count < taskCount; count++) {
            System.out.printf("    %d. %s%n", count + 1, this.taskList[count].getTaskString());
        }
    }

    public Task getTask(int taskNo) {
        return this.taskList[taskNo - 1];
    }

    public int getTaskCount() {
        return this.taskCount;
    }
}
