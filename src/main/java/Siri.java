import java.util.Scanner;

public class Siri {
    public static void printHorizontalLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void main(String[] args) {
        // Welcome message
        printHorizontalLine();
        System.out.println("    Hello! I'm Siri. " + "\uD83D\uDE0A");
        System.out.println("    What can I do for you?");
        printHorizontalLine();

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

            } else if (!line.equals("bye")) { // Add new task
                Task task = new Task(line);
                taskList.addTask(task);
                System.out.println("    added: " + line);
            }

            // Print line if loop continues
            if (!line.equals("bye")) {
                printHorizontalLine();
            }
        }

        // Exit message
        System.out.println("    Bye. Hope to see you again soon!");
        printHorizontalLine();
    }
}
