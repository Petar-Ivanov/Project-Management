package uni.pu.fmi.services;

import org.apache.commons.lang3.StringUtils;
import uni.pu.fmi.models.User;
import uni.pu.fmi.models.UserProjectRole;
import uni.pu.fmi.repos.TaskRepo;
import uni.pu.fmi.repos.TaskStatusRepo;
import uni.pu.fmi.repos.UserProjectRoleRepo;
import uni.pu.fmi.repos.UserRepo;

import java.time.LocalDateTime;

public class TaskService {

    public String changeStatus(String taskTitle, String userName, String newStatus) {
        if(taskTitle.isBlank()){
            return "Моля, посочете заглавие на задача";
        }
        if(userName.isBlank()){
            return "Моля, посочете име на потребител";
        }
        if(newStatus.isBlank()){
            return "Моля, посочете статус";
        }

        UserRepo userRepo = new UserRepo();
        boolean doesUserExist = userRepo.getAllUsers()
                .stream()
                .anyMatch(u -> u.getUsername()
                        .equals(userName));
        if(!doesUserExist){
            return "Потребителят не е открит";
        }

        TaskRepo taskRepo = new TaskRepo();
        boolean doesTaskExist = taskRepo.getAllTasks()
                .stream()
                .anyMatch(t -> t.getTitle()
                        .equals(taskTitle));
        if(!doesTaskExist){
            return "Задачата не е открита";
        }

        TaskStatusRepo taskStatusRepo = new TaskStatusRepo();
        boolean doesTaskStatusExist = taskStatusRepo.getAllTaskStatuses()
                .stream()
                .anyMatch(t -> t.getTitle()
                        .equals(newStatus));
        if(!doesTaskStatusExist){
            return "Статусът не е валиден";
        }

        UserProjectRoleRepo userProjectRoleRepo = new UserProjectRoleRepo();
        UserProjectRole userProjectRole = userProjectRoleRepo.getAllUserProjectRoles()
                .stream()
                .filter(u -> u.getUserName().equals(userName))
                .findFirst()
                .orElse(null);

        assert userProjectRole != null;
        if(!new PermissionService().canChangeProjectRoles(userProjectRole.getRoleTitle())){
            return "Потребителя няма право да променя статусът";
        }

        return "Статусът е променен успешно";
    }
}
