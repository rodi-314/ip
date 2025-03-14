import siri.parser.Parser;
import siri.storage.Storage;
import siri.tasks.*;
import siri.ui.Ui;

import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Siri {
    private static final TaskList taskList = new TaskList();

    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        Storage.loadTasks(taskList);

        // Request for user input
        String userInput = "";
        Scanner in = new Scanner(System.in);

        // Main loop
        while (!Parser.isExitCommand(userInput)) {
            userInput = in.nextLine();
            Ui.printHorizontalLine();

            try {
                if (Parser.isListCommand(userInput)) { // List tasks
                    Ui.printListTasks();
                    taskList.printTaskList();

                } else if (Parser.isFindCommand(userInput)) { // Find tasks
                    try {
                        String description = Parser.parseFindCommand(userInput);
                        Ui.printTasksFound();
                        taskList.printFindTasks(description);
                    } catch (NullPointerException e) {
                        throw new SiriException("Oops! The search field cannot be empty. \uD83D\uDE32");
                    }

                } else if (Parser.isMarkCommand(userInput) || Parser.isUnmarkCommand(userInput)) { // Mark/Unmark tasks
                    try {
                        Task task = Parser.parseMarkCommand(userInput, taskList);
                        task.setStatus(Parser.isMarkCommand(userInput));
                        if (Parser.isMarkCommand(userInput)) {
                            Ui.printTaskMarked();
                        } else {
                            Ui.printTaskUnmarked();
                        }
                        Ui.printTask(task);

                    } catch (NumberFormatException | NullPointerException |
                             IndexOutOfBoundsException e) { // Invalid task number inputted
                        throw new SiriException("Please input a valid integer task number! \uD83D\uDE32");
                    }

                } else if (Parser.isDeleteCommand(userInput)) { // Delete tasks
                    try {
                        int taskNo = Parser.parseDeleteCommand(userInput);
                        if (taskNo > taskList.getTaskCount()) {
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        Task task = taskList.getTask(taskNo);
                        taskList.removeTask(taskNo);
                        Ui.printTaskRemoved();
                        Ui.printTask(task);

                    } catch (NumberFormatException | IndexOutOfBoundsException e) { // Invalid task number inputted
                        throw new SiriException("Please input a valid integer task number! \uD83D\uDE32");
                    }

                } else if (Parser.isTodoCommand(userInput)) { // Add new todo
                    try {
                        Todo todo = Parser.parseTodoCommand(userInput);
                        taskList.addTask(todo);
                        Ui.printTaskAdded(todo.getTaskString(), taskList);
                    } catch (NullPointerException e) {
                        throw new SiriException("Oops! The description of a todo cannot be empty. \uD83D\uDE32");
                    }

                } else if (Parser.isDeadlineCommand(userInput)) { // Add new deadline
                    try {
                        Deadline deadline = Parser.parseDeadlineCommand(userInput);
                        taskList.addTask(deadline);
                        Ui.printTaskAdded(deadline.getTaskString(), taskList);
                    } catch (DataFormatException e) {
                        throw new SiriException("Please enter the command in the correct format: " +
                                "deadline DESCRIPTION /by DEADLINE \uD83D\uDE32 ");
                    } catch (DateTimeParseException e) {
                        throw new SiriException("Please enter DEADLINE in the correct format: " +
                                "yyyy-mm-ddThh:mm \uD83D\uDE32 ");
                    }

                } else if (Parser.isEventCommand(userInput)) { // Add new event
                    try {
                        Event event = Parser.parseEventCommand(userInput);
                        taskList.addTask(event);
                        Ui.printTaskAdded(event.getTaskString(), taskList);
                    } catch (DataFormatException e) {
                        throw new SiriException("Please enter the command in the correct format: " +
                                "event DESCRIPTION /from START_TIME /to END_TIME \uD83D\uDE32 ");
                    }

                } else if (!Parser.isExitCommand(userInput)) { // Invalid input
                    throw new SiriException("Oops! I'm sorry, but I don't know what that means... \uD83D\uDE14 " +
                            "Please provide a valid input!");
                }

            } catch (SiriException error) {
                Ui.printError(error);
            }

            // Update saveFile if task list changes
            if (Parser.isMarkCommand(userInput) ||
                    Parser.isUnmarkCommand(userInput) ||
                    Parser.isDeleteCommand(userInput) ||
                    Parser.isTodoCommand(userInput) ||
                    Parser.isDeadlineCommand(userInput) ||
                    Parser.isEventCommand(userInput)) {
                Storage.saveTasks(taskList);
            }

            // Print userInput if loop continues
            if (!Parser.isExitCommand(userInput)) {
                Ui.printHorizontalLine();
            }
        }

        Ui.printExitMessage();
    }
}
