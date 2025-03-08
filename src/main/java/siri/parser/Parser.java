package siri.parser;

import siri.tasks.*;

public class Parser {
    public static boolean isExitCommand(String userInput) {
        return userInput.equals("bye");
    }

    public static boolean isListCommand(String userInput) {
        return userInput.equals("list");
    }

    public static boolean isFindCommand(String userInput) {
        return userInput.startsWith("find");
    }

    public static boolean isMarkCommand(String userInput) {
        return userInput.startsWith("mark");
    }

    public static boolean isUnmarkCommand(String userInput) {
        return userInput.startsWith("unmark");
    }

    public static boolean isDeleteCommand(String userInput) {
        return userInput.startsWith("delete");
    }

    public static boolean isTodoCommand(String userInput) {
        return userInput.startsWith("todo");
    }

    public static boolean isDeadlineCommand(String userInput) {
        return userInput.startsWith("deadline");
    }

    public static boolean isEventCommand(String userInput) {
        return userInput.startsWith("event");
    }

    public static String parseFindCommand(String userInput) {
        if (userInput.equals("find")) {
            throw new NullPointerException();
        }
        return userInput.replace("find ", "");
    }

    public static Task parseMarkCommand(String userInput, TaskList taskList) throws NumberFormatException, NullPointerException {
        String taskNoString = userInput.split(" ")[1];
        int taskNo = Integer.parseInt(taskNoString);
        return taskList.getTask(taskNo);
    }

    public static int parseDeleteCommand(String userInput) throws NumberFormatException, NullPointerException {
        String taskNoString = userInput.split(" ")[1];
        return Integer.parseInt(taskNoString);
    }

    public static Todo parseTodoCommand(String userInput) throws NullPointerException {
        if (userInput.equals("todo")) {
            throw new NullPointerException();
        }
        String description = userInput.replace("todo ", "");
        return new Todo(description, false);
    }

    public static Deadline parseDeadlineCommand(String userInput) {
        int byIndex = userInput.indexOf("/by");
        String description = userInput.substring(9, byIndex - 1);
        String by = userInput.substring(byIndex + 4);
        return new Deadline(description, false, by);
    }

    public static Event parseEventCommand(String userInput) {
        int fromIndex = userInput.indexOf("/from");
        int toIndex = userInput.indexOf("/to");
        String description = userInput.substring(6, fromIndex - 1);
        String from = userInput.substring(fromIndex + 6, toIndex - 1);
        String to = userInput.substring(toIndex + 4);
        return new Event(description, false, from, to);
    }
}
