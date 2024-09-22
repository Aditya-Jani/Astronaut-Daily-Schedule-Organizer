# Astronaut Daily Schedule Organizer

This project is a console-based Java application that helps astronauts organize their daily schedules. The program allows users to add, remove, edit, view, and manage tasks effectively. It leverages multiple software design patterns (Behavioral, Structural, Creational) and adheres to solid design principles, logging, and error-handling best practices.

## Description

The **Astronaut Daily Schedule Organizer** is designed to manage daily tasks for astronauts, with key features including creating tasks, preventing overlapping schedules, and prioritizing tasks. This project showcases the application of key design patterns such as **Singleton**, **Factory**, **Command**, and **Observer**, while ensuring best practices like exception handling, defensive programming, and logging.

Tasks include a description, start time, end time, and priority level (low/medium/high), with features to mark tasks as completed, view by priority, and handle task editing.

---

## Features

- **Add a New Task:** Users can add a task with a description, start time, end time, and priority level.
- **Remove an Existing Task:** Remove tasks from the schedule by providing the task description.
- **View All Tasks:** List all tasks sorted by their start time.
- **Mark Task as Completed:** Mark any task as completed.
- **Edit an Existing Task:** Modify task details including description, start and end times, and priority.
- **View Tasks by Priority:** Filter and display tasks by priority level.
- **Conflict Detection:** Automatically detect conflicts when tasks overlap in time.
- **Error Handling:** Gracefully handle invalid inputs, task conflicts, and other exceptions.
- **Logging:** Log system events and errors for better traceability.

---

## Design Patterns Used

### 1. **Behavioral Patterns**
- **Command Pattern:** Used to encapsulate task-related operations (add, remove, edit) as commands.
- **Observer Pattern:** Used to monitor conflicts in task schedules and notify the user when a conflict arises.

### 2. **Creational Patterns**
- **Singleton Pattern:** Ensures only one instance of the `ScheduleManager` exists, managing all tasks centrally.
- **Factory Pattern:** Responsible for creating different `Task` objects based on the given attributes (description, start time, end time, and priority).

### 3. **Structural Patterns**
- **Facade Pattern:** Simplifies interaction with the system by providing a unified interface to various task-related operations (add, remove, view).
- **Adapter Pattern:** (Optional, if implemented) Can be used to integrate future features like different time formats or task import/export.

---

## Directory Structure
.
├── README.md
├── src
│   ├── Main.java                        # Main class that handles user input and interactions
│   ├── behavioral
│   │   ├── Command.java                 # Command interface for task actions
│   │   ├── AddTaskCommand.java          # Concrete class for adding tasks
│   │   ├── RemoveTaskCommand.java       # Concrete class for removing tasks
│   │   ├── EditTaskCommand.java         # Concrete class for editing tasks
│   │   ├── ConflictObserver.java        # Observer for task conflict detection
│   ├── creational
│   │   ├── TaskFactory.java             # Factory for creating tasks
│   │   ├── SingletonScheduleManager.java# Singleton for task management
│   ├── structural
│   │   ├── Task.java                    # Task entity class
│   │   ├── ScheduleManagerFacade.java   # Facade to simplify task management
├── logs
│   ├── application.log                  # Log file for application events and errors
└── README.md

