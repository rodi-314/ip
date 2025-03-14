package siri.tasks;

/**
 * Represents a task
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task instance
     *
     * @param description description of task
     * @param isDone boolean describing whether the task is done
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns icon representing the status of the task
     *
     * @return status icon
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Sets the status of the task (done/not done)
     *
     * @param isDone boolean describing whether the task is done
     */
    public void setStatus(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns string representation of task
     *
     * @return string representation of task
     */
    public String getTaskString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * Returns task description
     *
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns status of task (done/not done)
     *
     * @return boolean describing whether the task is done
     */
    public boolean getStatus() {
        return this.isDone;
    }
}