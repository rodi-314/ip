package siri.storage;

import siri.tasks.*;
import siri.ui.Ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class to load tasks from file or save tasks to file
 */
public class Storage {

    /**
     * Load tasks from file to the program
     *
     * @param taskList list of tasks
     */
    public static void loadTasks(TaskList taskList) {
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
                Ui.printError(e);
            }
        }
    }

    /**
     * Save tasks in program to file whenever there are changes to <code>taskList</code>
     *
     * @param taskList list of tasks
     */
    public static void saveTasks(TaskList taskList) {
        try {
            SaveFile.clearFile();
            for (Task task : taskList.getTaskList()) {
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
            Ui.printError(e);
        }
    }
}
