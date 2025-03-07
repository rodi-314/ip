package siri.ui;

import siri.tasks.Task;
import siri.tasks.TaskList;

public class Ui {
    public static void printHorizontalLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printWelcomeMessage() {
        printHorizontalLine();
        System.out.println("    Hello! I'm Siri. " + "\uD83D\uDE0A");
        System.out.println("    What can I do for you?");
        printHorizontalLine();
    }

    public static void printExitMessage() {
        System.out.println("    Bye. Hope to see you again soon!");
        printHorizontalLine();
    }

    public static void printListTasks() {
        System.out.println("    Here are the tasks in your list:");
    }

    public static void printTaskAdded(String taskString, TaskList taskList) {
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + taskString);
        System.out.println("    Now you have " + taskList.getTaskCount() + " tasks in the list.");
    }

    public static void printTask(Task task) {
        System.out.println("       " + task.getTaskString());
    }

    public static void printTaskMarked() {
        System.out.println("     Nice! I've marked this task as done:");
    }

    public static void printTaskUnmarked() {
        System.out.println("     OK, I've marked this task as not done yet:");
    }

    public static void printTaskRemoved() {
        System.out.println("     Noted. I've removed this task:");
    }

    public static void printInvalidTaskError() {
        System.out.println("    Please input a valid integer task number");
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
