package siri.parser;

import siri.tasks.*;

/**
 * Utility class that parses user commands
 */
public class Parser {

    /**
     * Returns a boolean describing whether user command entered is an exit command
     *
     * @param userInput command entered by user
     * @return true if user entered exit command, false otherwise
     */
    public static boolean isExitCommand(String userInput) {
        return userInput.startsWith("bye");
    }

    /**
     * Returns a boolean describing whether user command entered is a list command
     *
     * @param userInput command entered by user
     * @return true if user entered list command, false otherwise
     */
    public static boolean isListCommand(String userInput) {
        return userInput.startsWith("list");
    }

    /**
     * Returns a boolean describing whether user command entered is a find command
     *
     * @param userInput command entered by user
     * @return true if user entered find command, false otherwise
     */
    public static boolean isFindCommand(String userInput) {
        return userInput.startsWith("find");
    }

    /**
     * Returns a boolean describing whether user command entered is a mark command
     *
     * @param userInput command entered by user
     * @return true if user entered mark command, false otherwise
     */
    public static boolean isMarkCommand(String userInput) {
        return userInput.startsWith("mark");
    }

    /**
     * Returns a boolean describing whether user command entered is an unmark command
     *
     * @param userInput command entered by user
     * @return true if user entered unmark command, false otherwise
     */
    public static boolean isUnmarkCommand(String userInput) {
        return userInput.startsWith("unmark");
    }

    /**
     * Returns a boolean describing whether user command entered is a delete command
     *
     * @param userInput command entered by user
     * @return true if user entered delete command, false otherwise
     */
    public static boolean isDeleteCommand(String userInput) {
        return userInput.startsWith("delete");
    }

    /**
     * Returns a boolean describing whether user command entered is a todo command
     *
     * @param userInput command entered by user
     * @return true if user entered todo command, false otherwise
     */
    public static boolean isTodoCommand(String userInput) {
        return userInput.startsWith("todo");
    }

    /**
     * Returns a boolean describing whether user command entered is a deadline command
     *
     * @param userInput command entered by user
     * @return true if user entered deadline command, false otherwise
     */
    public static boolean isDeadlineCommand(String userInput) {
        return userInput.startsWith("deadline");
    }

    /**
     * Returns a boolean describing whether user command entered is an event command
     *
     * @param userInput command entered by user
     * @return true if user entered event command, false otherwise
     */
    public static boolean isEventCommand(String userInput) {
        return userInput.startsWith("event");
    }

    /**
     * Returns the description entered in the find command
     *
     * @param userInput find command entered by user
     * @return description
     * @throws NullPointerException if description is empty
     */
    public static String parseFindCommand(String userInput) throws NullPointerException {
        if (userInput.equals("find")) {
            throw new NullPointerException();
        }
        return userInput.replace("find ", "");
    }

    /**
     * Returns the task entered in the mark/unmark command
     *
     * @param userInput mark/unmark command entered by user
     * @param taskList  list of tasks
     * @return task corresponding to task number entered
     * @throws NumberFormatException if user did not enter an integer
     * @throws NullPointerException  if task corresponding to task number cannot be found
     */
    public static Task parseMarkCommand(String userInput, TaskList taskList) throws NumberFormatException, NullPointerException {
        String taskNoString = userInput.split(" ")[1];
        int taskNo = Integer.parseInt(taskNoString);
        return taskList.getTask(taskNo);
    }

    /**
     * Returns the task number in the delete command
     *
     * @param userInput delete command entered by user
     * @return task number entered
     * @throws NumberFormatException if user did not enter an integer
     */
    public static int parseDeleteCommand(String userInput) throws NumberFormatException {
        String taskNoString = userInput.split(" ")[1];
        return Integer.parseInt(taskNoString);
    }

    /**
     * Returns todo task as specified in the todo command
     *
     * @param userInput todo command entered by user
     * @return todo task
     * @throws NullPointerException if user did not enter a description
     */
    public static Todo parseTodoCommand(String userInput) throws NullPointerException {
        if (userInput.equals("todo")) {
            throw new NullPointerException();
        }
        String description = userInput.replace("todo ", "");
        return new Todo(description, false);
    }

    /**
     * Returns deadline task as specified in deadline command
     *
     * @param userInput deadline command entered by user
     * @return deadline task
     */
    public static Deadline parseDeadlineCommand(String userInput) {
        int byIndex = userInput.indexOf("/by");
        String description = userInput.substring(9, byIndex - 1);
        String by = userInput.substring(byIndex + 4);
        return new Deadline(description, false, by);
    }

    /**
     * Returns event task as specified in the event command
     *
     * @param userInput event command entered by user
     * @return event task
     */
    public static Event parseEventCommand(String userInput) {
        int fromIndex = userInput.indexOf("/from");
        int toIndex = userInput.indexOf("/to");
        String description = userInput.substring(6, fromIndex - 1);
        String from = userInput.substring(fromIndex + 6, toIndex - 1);
        String to = userInput.substring(toIndex + 4);
        return new Event(description, false, from, to);
    }
}
