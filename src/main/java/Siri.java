import java.util.Scanner;

public class Siri {
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

    public static void main(String[] args) {
        printWelcomeMessage();

        // Initialise taskList
        TaskList taskList = new TaskList();

        // Request for user input
        String line = "";
        Scanner in = new Scanner(System.in);

        // Main loop
        while (!line.equals("bye")) {
            line = in.nextLine();
            printHorizontalLine();

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

            } else if (line.startsWith("todo")) { // Add new todo
                String description = line.replace("todo ", "");
                Todo todo = new Todo(description);
                taskList.addTask(todo);
                printTaskAdded(todo.getTaskString(), taskList.getTaskCount());
            } else if (line.startsWith("deadline")) { // Add new deadline
                int byIndex = line.indexOf("/by");
                String description = line.substring(9, byIndex - 1);
                String by = line.substring(byIndex + 4);
                Deadline deadline = new Deadline(description, by);
                taskList.addTask(deadline);
                printTaskAdded(deadline.getTaskString(), taskList.getTaskCount());
            } else if (line.startsWith("event")) { // Add new event
                int fromIndex = line.indexOf("/from");
                int toIndex = line.indexOf("/to");
                String description = line.substring(6, fromIndex - 1);
                String from = line.substring(fromIndex + 6, toIndex - 1);
                String to = line.substring(toIndex + 4);
                Event event = new Event(description, from, to);
                taskList.addTask(event);
                printTaskAdded(event.getTaskString(), taskList.getTaskCount());

            } else if (!line.equals("bye")) { // Invalid input
                System.out.println("    Please provide a valid input");
            }

            // Print line if loop continues
            if (!line.equals("bye")) {
                printHorizontalLine();
            }
        }

        printExitMessage();
    }
}
