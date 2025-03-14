package siri.tasks;

/**
 * Represents a todo task
 */
public class Todo extends Task {

    /**
     * Creates a todo task instance
     *
     * @param description description of todo task
     * @param isDone boolean describing whether todo task is done
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Returns string representation of todo task
     *
     * @return string representation of todo task
     */
    @Override
    public String getTaskString() {
        return "[T]" + super.getTaskString();
    }
}
