package uni.pu.fmi.repos;

import uni.pu.fmi.models.Project;
import uni.pu.fmi.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectRepo implements IProjectRepo{

    @Override
    public List<Project> getAllProjects() {

        ArrayList<Project> projects = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();
        List<User> users = new UserRepo().getAllUsers();

        Project project = new Project(
                "Project",
                "Project description text...",
                now.plusDays(30),
                now,
                users.get(new Random().nextInt(users.size())).getUsername()
        );

        Project project1 = new Project(
                "Project1",
                "Project1 description text...",
                now.plusDays(31),
                now,
                users.get(new Random().nextInt(users.size())).getUsername()
        );

        Project project2 = new Project(
                "Project2",
                "Project2 description text...",
                now.plusDays(31),
                now,
                users.get(new Random().nextInt(users.size())).getUsername()
        );

        projects.add(project);
        projects.add(project1);
        projects.add(project2);

        return projects;
    }

    public void addProject(Project project) {
            getAllProjects().add(project);
    }
}
