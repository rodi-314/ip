package siri.ui;

import siri.tasks.Task;
import siri.tasks.TaskList;

public class Ui {

    private static final String SPACER = "     ";
    private static final String TASK_SPACER = "       ";

    public static void printHorizontalLine() {
        System.out.println(SPACER + "____________________________________________________________");
    }

    public static void printWelcomeMessage() {
        printHorizontalLine();
        System.out.println(SPACER + "Hello! I'm Siri. " + "\uD83D\uDE0A");
        System.out.println(SPACER + "What can I do for you?");
        printHorizontalLine();
    }

    public static void printExitMessage() {
        System.out.println(SPACER + "Bye. Hope to see you again soon!");
        printHorizontalLine();
    }

    public static void printListTasks() {
        System.out.println(SPACER + "Here are the tasks in your list:");
    }

    public static void printTaskAdded(String taskString, TaskList taskList) {
        System.out.println(SPACER + "Got it. I've added this task:");
        System.out.println(TASK_SPACER + taskString);
        System.out.println(SPACER + "Now you have " + taskList.getTaskCount() + " tasks in the list.");
    }

    public static void printTask(Task task) {
        System.out.println(TASK_SPACER + task.getTaskString());
    }

    public static void printTaskMarked() {
        System.out.println(SPACER + "Nice! I've marked this task as done:");
    }

    public static void printTaskUnmarked() {
        System.out.println(SPACER + "OK, I've marked this task as not done yet:");
    }

    public static void printTaskRemoved() {
        System.out.println(SPACER + "Noted. I've removed this task:");
    }

    public static void printTasksFound() {
        System.out.println(SPACER + "Here are the matching tasks in your list:");
    }

    public static void printInvalidTaskError() {
        System.out.println(SPACER + "Please input a valid integer task number");
    }

    public static void printError(Exception e) {
        System.out.println(SPACER + e.getMessage());
    }
}
