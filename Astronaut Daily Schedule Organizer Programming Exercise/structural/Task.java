package structural;

public class Task implements Comparable<Task> {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;
    private boolean isCompleted;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = false;
    }

    // Getter and Setter methods
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public boolean isCompleted() { return isCompleted; }
    public void markCompleted() { this.isCompleted = true; }

    @Override
    public int compareTo(Task o) {
        return this.startTime.compareTo(o.startTime);
    }

    public boolean conflictsWith(Task other) {
        // Check if tasks overlap
        return this.startTime.compareTo(other.endTime) < 0 && this.endTime.compareTo(other.startTime) > 0;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]" + (isCompleted ? " [Completed]" : "");
    }
}
