package behavioral;

import creational.SingletonScheduleManager;

public class RemoveTaskCommand implements Command {
    private SingletonScheduleManager scheduleManager;
    private String taskDescription;

    public RemoveTaskCommand(SingletonScheduleManager scheduleManager, String taskDescription) {
        this.scheduleManager = scheduleManager;
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute() {
        scheduleManager.removeTask(taskDescription);
    }
}
