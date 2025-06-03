package uni.pu.fmi.services;

import org.apache.commons.validator.routines.EmailValidator;
import uni.pu.fmi.models.User;
import uni.pu.fmi.repos.UserRepo;

public class RegisterService {
    public String register(String username, String password, String password2, String email, String phone) {
        String errorMessage = validate(username, password, password2, email);
        if (errorMessage != null){
            return errorMessage;
        }
        createUser(username, password, email, phone);
        return "Успешна регистрация";
    }

    private static void createUser(String username, String password, String email, String phone) {
        User user = new User(email, username, password, phone);
        new UserRepo().addUser(user);
    }

    private static String validate(String username, String password, String password2, String email) {
        if (username.length() < 3 || username.length() > 20) {
            return "Името трябва да е между 3 20 букви";
        }
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(email)) {
            return "Електронната поща е невалидна";
        }
        if (!password.equals(password2)) {
            return "Паролите са различни";
        }
        boolean isUsernameExist = new UserRepo().getAllUsers()
            .stream()
            .anyMatch(u -> u.getUsername()
                .equals(username));
        if (isUsernameExist) {
            return "Заето име";
        }
        return null;
    }
}
