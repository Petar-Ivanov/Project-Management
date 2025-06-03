package uni.pu.fmi.repos;

import uni.pu.fmi.models.TaskStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskStatusRepo implements ITaskStatusRepo{
    @Override
    public List<TaskStatus> getAllTaskStatuses() {
        ArrayList<TaskStatus> taskStatuses = new ArrayList<>();

        TaskStatus taskStatus = new TaskStatus("To do");
        TaskStatus taskStatus1 = new TaskStatus("In Progress");
        TaskStatus taskStatus2 = new TaskStatus("Review");
        TaskStatus taskStatus3 = new TaskStatus("Done");

        taskStatuses.add(taskStatus);
        taskStatuses.add(taskStatus1);
        taskStatuses.add(taskStatus2);
        taskStatuses.add(taskStatus3);

        return taskStatuses;
    }

    public void addTaskStatus(TaskStatus taskStatus) {
        getAllTaskStatuses().add(taskStatus);
    }
}
