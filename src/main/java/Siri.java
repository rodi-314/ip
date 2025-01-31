import java.util.Scanner;

public class Siri {
    public static void printHorizontalLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void main(String[] args) {
        printHorizontalLine();
        System.out.println("    Hello! I'm Siri. " + "\uD83D\uDE0A");
        System.out.println("    What can I do for you?");
        printHorizontalLine();

        String line = "";
        Scanner in = new Scanner(System.in);
        while (!line.equals("bye")) {
            line = in.nextLine();
            printHorizontalLine();
            if (!line.equals("bye")) {
                System.out.println("    " + line);
                printHorizontalLine();
            }
        }

        System.out.println("    Bye. Hope to see you again soon!");
        printHorizontalLine();
    }
}
