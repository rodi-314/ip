package siri.tasks;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String getTaskString() {
        return "[D]" + super.getTaskString() + " (by: " + this.by + ")";
    }
}
