package siri.tasks;

/**
 * Represents an event task
 */
public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Creates an event task instance
     *
     * @param description description of event task
     * @param isDone boolean describing whether event task is done
     * @param from start time of event
     * @param to end time of event
     */
    public Event(String description, boolean isDone, String from, String to) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns start time of event
     *
     * @return start time
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Returns end time of event
     *
     * @return end time
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Returns string representation of event task
     *
     * @return string representation of event task
     */
    @Override
    public String getTaskString() {
        return "[E]" + super.getTaskString() + " (from: " + this.from + " to: " + this.to + ")";
    }
}
