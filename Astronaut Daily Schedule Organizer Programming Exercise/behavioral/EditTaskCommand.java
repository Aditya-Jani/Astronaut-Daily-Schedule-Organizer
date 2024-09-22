package behavioral;

import creational.SingletonScheduleManager;
import structural.Task;

public class EditTaskCommand implements Command {
    private final SingletonScheduleManager manager;
    private final String oldDescription;
    private final Task newTask;

    public EditTaskCommand(SingletonScheduleManager manager, String oldDescription, Task newTask) {
        this.manager = manager;
        this.oldDescription = oldDescription;
        this.newTask = newTask;
    }

    @Override
    public void execute() {
        try {
            manager.editTask(oldDescription, newTask);
            System.out.println("Task edited successfully.");
        } catch (Exception e) {
            System.err.println("Error editing task: " + e.getMessage());
        }
    }
}
