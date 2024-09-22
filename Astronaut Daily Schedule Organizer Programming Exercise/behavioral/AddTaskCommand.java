package behavioral;

import creational.SingletonScheduleManager;
import structural.Task;

public class AddTaskCommand implements Command {
    private SingletonScheduleManager scheduleManager;
    private Task task;

    public AddTaskCommand(SingletonScheduleManager scheduleManager, Task task) {
        this.scheduleManager = scheduleManager;
        this.task = task;
    }

    @Override
    public void execute() {
        scheduleManager.addTask(task);
    }
}
