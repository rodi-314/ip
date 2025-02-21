import siri.files.SaveFile;
import siri.tasks.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Siri {
    // Initialise taskList
    private static TaskList taskList = new TaskList();

    public static void printHorizontalLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printWelcomeMessage() {
        printHorizontalLine();
        System.out.println("    Hello! I'm Siri. " + "\uD83D\uDE0A");
        System.out.println("    What can I do for you?");
        printHorizontalLine();
    }

    public static void printTaskAdded(String taskString, int taskCount) {
        System.out.println("    Got it. I've added this task:");
        System.out.println("      " + taskString);
        System.out.println("    Now you have " + taskCount + " tasks in the list.");
    }

    public static void printExitMessage() {
        System.out.println("    Bye. Hope to see you again soon!");
        printHorizontalLine();
    }

    public static void loadTasks() {
        try {
            Scanner scanner = SaveFile.getScanner();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");
                if (data[0].equals("T")) {
                    taskList.addTask(new Todo(data[2], Boolean.parseBoolean(data[1])));
                } else if (data[0].equals("D")) {
                    taskList.addTask(new Deadline(data[2], Boolean.parseBoolean(data[1]), data[3]));
                } else {
                    taskList.addTask(new Event(data[2], Boolean.parseBoolean(data[1]), data[3], data[4]));
                }
            }
        } catch (FileNotFoundException e) {
            try {
                SaveFile.clearFile();
            } catch (IOException ex) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    public static void saveTasks(TaskList taskList) {
        try {
            SaveFile.clearFile();
            for (int count = 0; count < taskList.getTaskCount(); count++) {
                Task task = taskList.getTaskList()[count];
                if (task.getClass() == Todo.class) {
                    SaveFile.appendToFile("T" + "|" +
                            task.getStatus() + "|" +
                            task.getDescription() + System.lineSeparator());
                } else if (task.getClass() == Deadline.class) {
                    Deadline deadline = (Deadline) task;
                    SaveFile.appendToFile("D" + "|" +
                            deadline.getStatus() + "|" +
                            deadline.getDescription() + "|" +
                            deadline.getBy() + System.lineSeparator());
                } else {
                    Event event = (Event) task;
                    SaveFile.appendToFile("E" + "|" +
                            event.getStatus() + "|" +
                            event.getDescription() + "|" +
                            event.getFrom() + "|" +
                            event.getTo() + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        printWelcomeMessage();
        loadTasks();

        // Request for user input
        String line = "";
        Scanner in = new Scanner(System.in);

        // Main loop
        while (!line.equals("bye")) {
            line = in.nextLine();
            printHorizontalLine();

            try {
                if (line.equals("list")) { // List tasks
                    System.out.println("    Here are the tasks in your list:");
                    taskList.printTaskList();

                } else if (line.startsWith("mark") || line.startsWith("unmark")) { // Mark/Unmark tasks
                    String taskNoString = line.split(" ")[1];
                    try {
                        int taskNo = Integer.parseInt(taskNoString);
                        Task task = taskList.getTask(taskNo);
                        task.setStatus(line.startsWith("mark"));
                        if (line.startsWith("mark")) {
                            System.out.println("     Nice! I've marked this task as done:");
                        } else {
                            System.out.println("     OK, I've marked this task as not done yet:");
                        }
                        System.out.println("       " + task.getTaskString());

                    } catch (NumberFormatException | NullPointerException |
                             ArrayIndexOutOfBoundsException e) { // Invalid task number inputted
                        System.out.println("    Please input a valid integer task number");
                    }

                } else if (line.startsWith("delete")) { // Delete tasks
                    String taskNoString = line.split(" ")[1];
                    try {
                        int taskNo = Integer.parseInt(taskNoString);
                        Task task = taskList.getTask(taskNo);
                        if (taskNo > taskList.getTaskCount()) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        taskList.removeTask(taskNo);
                        System.out.println("     Noted. I've removed this task:");
                        System.out.println("       " + task.getTaskString());

                    } catch (NumberFormatException | NullPointerException |
                             ArrayIndexOutOfBoundsException e) { // Invalid task number inputted
                        System.out.println("    Please input a valid integer task number");
                    }

                } else if (line.startsWith("todo")) { // Add new todo
                    if (line.equals("todo")) {
                        throw new SiriException("    Oops! The description of a todo cannot be empty. \uD83D\uDE14");
                    }
                    String description = line.replace("todo ", "");
                    Todo todo = new Todo(description, false);
                    taskList.addTask(todo);
                    printTaskAdded(todo.getTaskString(), taskList.getTaskCount());
                } else if (line.startsWith("deadline")) { // Add new deadline
                    int byIndex = line.indexOf("/by");
                    String description = line.substring(9, byIndex - 1);
                    String by = line.substring(byIndex + 4);
                    Deadline deadline = new Deadline(description, false, by);
                    taskList.addTask(deadline);
                    printTaskAdded(deadline.getTaskString(), taskList.getTaskCount());
                } else if (line.startsWith("event")) { // Add new event
                    int fromIndex = line.indexOf("/from");
                    int toIndex = line.indexOf("/to");
                    String description = line.substring(6, fromIndex - 1);
                    String from = line.substring(fromIndex + 6, toIndex - 1);
                    String to = line.substring(toIndex + 4);
                    Event event = new Event(description, false, from, to);
                    taskList.addTask(event);
                    printTaskAdded(event.getTaskString(), taskList.getTaskCount());

                } else if (!line.equals("bye")) { // Invalid input
                    throw new SiriException("    Oops! I'm sorry, but I don't know what that means... \uD83D\uDE14 " +
                            "Please provide a valid input!");
                }
            } catch (SiriException e) {
                System.out.println(e.getMessage());
            }

            // Update saveFile if task list changes
            if (line.startsWith("mark") ||
                    line.startsWith("unmark") ||
                    line.startsWith("delete") ||
                    line.startsWith("todo") ||
                    line.startsWith("deadline") ||
                    line.startsWith("event")) {
                saveTasks(taskList);
            }

            // Print line if loop continues
            if (!line.equals("bye")) {
                printHorizontalLine();
            }
        }

        printExitMessage();
    }
}
