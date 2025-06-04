package uni.pu.fmi.repos;

import uni.pu.fmi.models.Project;
import uni.pu.fmi.models.Task;
import uni.pu.fmi.models.TaskStatus;
import uni.pu.fmi.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskRepo implements ITaskRepo{
    @Override
    public List<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();
        List<User> users = new UserRepo().getAllUsers();
        List<Project> projects = new ProjectRepo().getAllProjects();
        List<TaskStatus> statuses = new TaskStatusRepo().getAllTaskStatuses();

        Task task = new Task(
                "Task",
                "This is an example of a description",
                now.plusDays(30),
                3,
                "Type 1",
                statuses.get(new Random().nextInt(statuses.size())).getTitle(),
                now,
                users.get(new Random().nextInt(users.size())).getUsername(),
                "Project"
        );
        Task task1 = new Task(
                "Task1",
                "This is an example of a description",
                now.plusDays(31),
                2,
                "Type 1",
                statuses.get(new Random().nextInt(statuses.size())).getTitle(),
                now,
                users.get(new Random().nextInt(users.size())).getUsername(),
                "Project1"
        );

        tasks.add(task);
        tasks.add(task1);

        return tasks;
    }

    public void addTask(Task task) {
        getAllTasks().add(task);
    }
}
