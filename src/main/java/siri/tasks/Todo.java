package siri.tasks;

public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String getTaskString() {
        return "[T]" + super.getTaskString();
    }
}
