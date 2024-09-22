package structural;

import creational.SingletonScheduleManager;

public class ScheduleManagerFacade {
    private SingletonScheduleManager manager;

    public ScheduleManagerFacade() {
        manager = SingletonScheduleManager.getInstance();
    }

    public void addTask(String description, String startTime, String endTime, String priority) {
        Task task = new Task(description, startTime, endTime, priority);
        manager.addTask(task);
    }

    public void removeTask(String description) {
        manager.removeTask(description);
    }

    public void viewTasks() {
        manager.viewTasks();
        // manager.getTasks();
    }

    public void markTaskCompleted(String description) {
        for (Task task : manager.getTasks()) {
            if (task.getDescription().equals(description)) {
                task.markCompleted();
                System.out.println("Task marked as completed: " + description);
            }
        }
    }

    public void viewTasksByPriority(String priority) {
        manager.getTasks().stream()
            .filter(task -> task.getPriority().equalsIgnoreCase(priority))
            .forEach(System.out::println);
    }
}
