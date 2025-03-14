package siri.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task
 */
public class Deadline extends Task {

    protected LocalDateTime by;

    /**
     * Creates a deadline task instance
     *
     * @param description description of deadline task
     * @param isDone      boolean describing whether deadline task is done
     * @param by          deadline of task
     */
    public Deadline(String description, boolean isDone, LocalDateTime by) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Returns deadline of deadline task
     *
     * @return deadline
     */
    public LocalDateTime getBy() {
        return by;
    }

    /**
     * Returns string representation of deadline task
     *
     * @return string representation of deadline task
     */
    @Override
    public String getTaskString() {
        return "[D]" + super.getTaskString() +
                " (by: " + this.by.format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")) + ")";
    }
}
