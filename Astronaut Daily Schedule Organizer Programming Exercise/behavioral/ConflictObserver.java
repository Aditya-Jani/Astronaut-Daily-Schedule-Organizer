package behavioral;

import structural.Task;
import java.util.List;

public class ConflictObserver implements Observer {
    @Override
    public void update(Task newTask, List<Task> existingTasks) {
        for (Task task : existingTasks) {
            if (task.conflictsWith(newTask)) {
                System.out.println("Conflict detected with task: " + task.getDescription());
                return;
            }
        }
    }
}
