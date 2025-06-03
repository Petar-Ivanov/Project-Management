package uni.pu.fmi.services;

import org.apache.commons.lang3.StringUtils;
import uni.pu.fmi.repos.UserRepo;

public class LoginService {
    public String login(String username, String password) {
        if (StringUtils.isAllBlank(username, password)) {
            return "Моля, въведете име и парола";
        }
        if (StringUtils.isBlank(username)) {
            return "Моля, въведете име";
        }
        if (StringUtils.isBlank(password)) {
            return "Моля, въведете парола";
        }
        if(username.length() < 3) {
            return "Късо име!!!";
        }
        UserRepo userRepo = new UserRepo();
        boolean isUserExist = userRepo.getAllUsers()
            .stream()
            .anyMatch(u -> u.getUsername()
                .equals(username) && u.getPassword()
                .equals(password));
        return isUserExist?"УРАААА":"Грешно име или парола";
    }
}
