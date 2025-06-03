package uni.pu.fmi.services;

import org.apache.commons.lang3.StringUtils;
import uni.pu.fmi.models.Project;
import uni.pu.fmi.models.User;
import uni.pu.fmi.repos.UserRepo;

import java.time.LocalDateTime;
import java.util.Random;

public class ProjectService {

    public String createProject(String title, String description, LocalDateTime finalDate, LocalDateTime createdOn, String creatorUsername) {
        if (StringUtils.isAllBlank(title, creatorUsername)){
            return "Липсват заглавие и потребителско име";
        }
        if (StringUtils.isBlank(title)) {
            return "Моля, въведете заглавие";
        }
        if (StringUtils.isBlank(creatorUsername)) {
            return "Липсва потребителско име";
        }
        if(title.length() < 3) {
            return "Късо заглавие!!!";
        }
        if(title.length() > 75) {
            return "Прекалено дълго заглавие!!!";
        }
        if(description.length() > 500) {
            return "Прекалено дълго описание!!!";
        }
        if (finalDate != null && finalDate.isBefore(LocalDateTime.now())) {
            return "Невалидна крайна дата";
        }
        UserRepo userRepo = new UserRepo();
        boolean doesUserExist = userRepo.getAllUsers()
                .stream()
                .anyMatch(u -> u.getUsername()
                        .equals(creatorUsername));
        return doesUserExist?"Успешно създаден проект":"Потребителят не е открит";
    }
}
