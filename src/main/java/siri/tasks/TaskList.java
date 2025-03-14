package siri.tasks;

import java.util.ArrayList;

/**
 * Represents a list of tasks
 */
public class TaskList {
    private final ArrayList<Task> taskList;

    /**
     * Creates a new task list instance
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds task specified to the task list
     *
     * @param task task
     */
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    /**
     * Removes task specified corresponding to the task number from the task list
     *
     * @param taskNo task number
     */
    public void removeTask(int taskNo) {
        this.taskList.remove(taskNo - 1);
    }

    /**
     * Prints list of tasks in order
     */
    public void printTaskList() {
        for (int count = 0; count < taskList.size(); count++) {
            System.out.printf("     %d. %s%n", count + 1, this.taskList.get(count).getTaskString());
        }
    }

    /**
     * Returns task specified corresponding to the task number
     *
     * @param taskNo task number
     * @return task
     */
    public Task getTask(int taskNo) {
        return this.taskList.get(taskNo - 1);
    }

    /**
     * Returns list of tasks
     *
     * @return task list
     */
    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    /**
     * Returns number of tasks in task list
     *
     * @return number of tasks
     */
    public int getTaskCount() {
        return this.taskList.size();
    }

    /**
     * Prints list of tasks found in order
     *
     * @param description description to be searched in task list
     */
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
