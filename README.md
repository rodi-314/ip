# Siri — Todo List Chatbot

This is a chatbot created for users to keep track of their tasks, such as to-dos, deadlines, and events. It's named
after Apple's virtual assistant _Siri_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project
   first)
1. Open the project into Intellij as follows:
    1. Click `Open`.
    1. Select the project directory, and click `OK`.
    1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained
   in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/Siri.java` file, right-click it, and choose `Run Siri.main()` (if the code
   editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the
   below as the output:
   ```
        ____________________________________________________________
        Hello! I'm Siri. 😊
        What can I do for you?
        ____________________________________________________________
   ```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move
Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle)
expect to find Java files.

## Features

> ℹ️ Notes about the command format:
>
> - Words in `UPPER_CASE` are the parameters to be supplied by the user. \
    > e.g. in `todo DESCRIPTION`, `DESCRIPTION` is a parameter which can be used as `todo borrow book`.
>
> - Extraneous parameters for commands that do not take in parameters (such as `list` and `exit`) will be ignored. \
    > e.g. if the command specifies `list 123`, it will be interpreted as `list`.

### Adding todo task: `todo`

Adds a todo task to the task list.

Format: `todo DESCRIPTION`

Examples:
- `todo borrow book`
- `todo buy groceries`

### Adding deadline task: `deadline`

Adds a deadline task to the task list.

Format: `deadline DESCRIPTION /by DEADLINE`

Examples:
- `deadline return book /by Sunday`
- `deadline cook dinner /by 6pm`

### Adding event task: `event`

Adds an event task to the task list.

Format: `event DESCRIPTION /from START_TIME /to END_TIME`

Examples:
- `event project meeting /from Mon 2pm /to 4pm`
- `event culinary event /from Tue 5pm /to 7pm`

### Listing tasks: `list`

Shows a list of all tasks in the task list.

Format: `list`

### Finding tasks: `find`

Search for tasks matching the given description.

Format: `find DESCRIPTION`

Examples:
- `find book`
- `find project`

### Marking task as done: `mark`

Marks the task with the corresponding task number specified as done.

Format: `mark TASK_NUMBER`

Examples:
- `mark 1`
- `mark 2`

### Marking task as not done: `unmark`

Marks the task with the corresponding task number specified as not done.

Format: `unmark TASK_NUMBER`

Examples:
- `unmark 1`
- `unmark 2`

### Removing task: `delete`

Deletes the task with the corresponding task number.

Format: `delete TASK_NUMBER`

Examples:
- `delete 1`
- `delete 2`

### Exiting the program: `exit`

Exits the program.

Format: `exit`

### Saving tasks

The task list is saved and loaded whenever the user exits or runs the program. No additional commands are needed to be
run to save/load the task list.