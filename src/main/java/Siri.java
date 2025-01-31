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

        // Initialise list
        String[] list = new String[100];
        int listCount = 0;


        // Request for user input
        String line = "";
        Scanner in = new Scanner(System.in);

        // Main loop
        while (!line.equals("bye")) {
            line = in.nextLine();
            printHorizontalLine();

            if (line.equals("list")) {
                for (int count = 0; count < listCount; count++) {
                    System.out.printf("    %d. %s%n", count + 1, list[count]);
                }
                printHorizontalLine();
            } else if (!line.equals("bye")) {
                list[listCount] = line;
                listCount++;
                System.out.println("    added: " + line);
                printHorizontalLine();
            }
        }

        // Exit message
        System.out.println("    Bye. Hope to see you again soon!");
        printHorizontalLine();
    }
}
