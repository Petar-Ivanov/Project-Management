package uni.pu.fmi.repos;

import uni.pu.fmi.models.TaskStatus;

import java.util.List;

public interface ITaskStatusRepo {
    List<TaskStatus> getAllTaskStatuses();
}
