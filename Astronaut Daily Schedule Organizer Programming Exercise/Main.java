import behavioral.AddTaskCommand;
import behavioral.Command;
import behavioral.ConflictObserver;
import behavioral.EditTaskCommand;
import behavioral.RemoveTaskCommand;
import creational.SingletonScheduleManager;
import creational.TaskFactory;
import structural.ScheduleManagerFacade;
import structural.Task;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Set up the logging configuration to write to a file
        try {
            Handler fileHandler = new FileHandler("application.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error setting up file logging", e);
        }

        Scanner scanner = new Scanner(System.in);
        ScheduleManagerFacade facade = new ScheduleManagerFacade();
        TaskFactory taskFactory = new TaskFactory();
        SingletonScheduleManager manager = SingletonScheduleManager.getInstance();
        ConflictObserver observer = new ConflictObserver();

        boolean continueRunning = true;

        while (continueRunning) {
            try {
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. View Tasks");
                System.out.println("4. Mark Task as Completed");
                System.out.println("5. View Tasks by Priority");
                System.out.println("6. Edit Task");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                Task newTask = null;  

                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter start time (HH:MM): ");
                        String startTime = scanner.nextLine();
                        System.out.print("Enter end time (HH:MM): ");
                        String endTime = scanner.nextLine();
                        System.out.print("Enter priority (low/medium/high): ");
                        String priority = scanner.nextLine();

                        newTask = taskFactory.createTask(description, startTime, endTime, priority);
                        Command addTask = new AddTaskCommand(manager, newTask);
                        addTask.execute();
                        observer.update(newTask, manager.getTasks());
                        logger.info("Task added Successfully.");
                        break;

                    case 2:
                        System.out.print("Enter task description to remove: ");
                        description = scanner.nextLine();
                        Command removeTask = new RemoveTaskCommand(manager, description);
                        removeTask.execute();
                        logger.info("Task removed Successfully.");
                        break;

                    case 3:
                        facade.viewTasks(); 
                        logger.info("Task viewed Successfully.");
                        break;

                    case 4:
                        System.out.print("Enter task description to mark as completed: ");
                        description = scanner.nextLine();
                        facade.markTaskCompleted(description);
                        logger.info("Task marked as completed Successfully.");

                        break;

                    case 5:
                        System.out.print("Enter priority (low/medium/high): ");
                        priority = scanner.nextLine();
                        facade.viewTasksByPriority(priority);
                        logger.info("Task viewded by priority Successfully.");
                        break;

                    case 6:
                        System.out.print("Enter task description to edit: ");
                        String oldDescription = scanner.nextLine();
                        System.out.print("Enter new task description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter new start time (HH:MM): ");
                        String newStartTime = scanner.nextLine();
                        System.out.print("Enter new end time (HH:MM): ");
                        String newEndTime = scanner.nextLine();
                        System.out.print("Enter new priority (low/medium/high): ");
                        
                        String newPriority = scanner.nextLine();

                        newTask = taskFactory.createTask(newDescription, newStartTime, newEndTime, newPriority);
                        Command editTask = new EditTaskCommand(manager, oldDescription, newTask);
                        editTask.execute();
                        logger.info("Task edited Successfully.");
                        break;

                    case 7:
                        continueRunning = false;
                        break;

                    default:
                        logger.warning("Invalid choice.");
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
            }
        }

        scanner.close();
        logger.info("Application terminated.");
    }
}
