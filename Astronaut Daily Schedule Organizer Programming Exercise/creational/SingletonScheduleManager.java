package creational;

import structural.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SingletonScheduleManager {
    private static SingletonScheduleManager instance;
    private final List<Task> tasks;
    private static final Logger logger = Logger.getLogger(SingletonScheduleManager.class.getName());

    private SingletonScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static SingletonScheduleManager getInstance() {
        if (instance == null) {
            instance = new SingletonScheduleManager();
        }
        return instance;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) throws IllegalArgumentException {
        if (task == null) {
            logger.severe("Attempted to add a null task.");
            throw new IllegalArgumentException("Task cannot be null.");
        }
        for (Task existingTask : tasks) {
            if (existingTask.conflictsWith(task)) {
                logger.warning("Task conflict detected: " + task.getDescription());
                throw new IllegalArgumentException("Task conflicts with an existing task.");
            }
        }
        tasks.add(task);
        logger.info("Task added: " + task.getDescription());
    }

    public void removeTask(String description) throws IllegalArgumentException {
        Task taskToRemove = findTaskByDescription(description);
        if (taskToRemove == null) {
            logger.warning("Attempted to remove a non-existent task: " + description);
            throw new IllegalArgumentException("Task not found.");
        }
        tasks.remove(taskToRemove);
        logger.info("Task removed: " + description);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.stream()
                .sorted((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()))
                .forEach(task -> System.out.println(task));
        }
    }

    public void editTask(String oldDescription, Task newTask) throws IllegalArgumentException {
        Task taskToEdit = findTaskByDescription(oldDescription);
        if (taskToEdit == null) {
            logger.warning("Attempted to edit a non-existent task: " + oldDescription);
            throw new IllegalArgumentException("Task not found.");
        }
        tasks.remove(taskToEdit);
        addTask(newTask);
        logger.info("Task edited: " + oldDescription + " to " + newTask.getDescription());
    }

    private Task findTaskByDescription(String description) {
        return tasks.stream()
                .filter(task -> task.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }
}
