package siri.ui;

import siri.tasks.Task;
import siri.tasks.TaskList;

/**
 * Utility class to print user interface text
 */
public class Ui {

    private static final String SPACER = "     ";
    private static final String TASK_SPACER = "       ";

    /**
     * Print horizontal line
     */
    public static void printHorizontalLine() {
        System.out.println(SPACER + "____________________________________________________________");
    }

    /**
     * Print welcome message
     */
    public static void printWelcomeMessage() {
        printHorizontalLine();
        System.out.println(SPACER + "Hello! I'm Siri. " + "\uD83D\uDE0A");
        System.out.println(SPACER + "What can I do for you?");
        printHorizontalLine();
    }

    /**
     * Print exit message
     */
    public static void printExitMessage() {
        System.out.println(SPACER + "Bye. Hope to see you again soon!");
        printHorizontalLine();
    }

    /**
     * Print header message before list of tasks
     */
    public static void printListTasks() {
        System.out.println(SPACER + "Here are the tasks in your list:");
    }

    /**
     * Print message to show task added
     *
     * @param taskString string representation of task
     * @param taskList list of tasks
     */
    public static void printTaskAdded(String taskString, TaskList taskList) {
        System.out.println(SPACER + "Got it. I've added this task:");
        System.out.println(TASK_SPACER + taskString);
        System.out.println(SPACER + "Now you have " + taskList.getTaskCount() + " tasks in the list.");
    }

    /**
     * Print task
     *
     * @param task task
     */
    public static void printTask(Task task) {
        System.out.println(TASK_SPACER + task.getTaskString());
    }

    /**
     * Print message to show task marked
     */
    public static void printTaskMarked() {
        System.out.println(SPACER + "Nice! I've marked this task as done:");
    }

    /**
     * Print message to show task unmarked
     */
    public static void printTaskUnmarked() {
        System.out.println(SPACER + "OK, I've marked this task as not done yet:");
    }

    /**
     * Print message to show task removed
     */
    public static void printTaskRemoved() {
        System.out.println(SPACER + "Noted. I've removed this task:");
    }

    /**
     * Print header message before list of tasks found
     */
    public static void printTasksFound() {
        System.out.println(SPACER + "Here are the matching tasks in your list:");
    }

    /**
     * Print error message
     *
     * @param e exception
     */
    public static void printError(Exception e) {
        System.out.println(SPACER + e.getMessage());
    }
}
