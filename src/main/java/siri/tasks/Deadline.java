package siri.tasks;

/**
 * Represents a deadline task
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Creates a deadline task instance
     *
     * @param description description of deadline task
     * @param isDone boolean describing whether deadline task is done
     * @param by deadline of task
     */
    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Returns deadline of deadline task
     *
     * @return deadline
     */
    public String getBy() {
        return by;
    }

    /**
     * Returns string representation of deadline task
     *
     * @return string representation of deadline task
     */
    @Override
    public String getTaskString() {
        return "[D]" + super.getTaskString() + " (by: " + this.by + ")";
    }
}
