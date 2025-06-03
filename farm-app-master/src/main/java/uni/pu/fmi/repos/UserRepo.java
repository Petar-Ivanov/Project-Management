package uni.pu.fmi.repos;

import uni.pu.fmi.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo
    implements IUserRepo {
    @Override
    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("User", "123", "user@jhgfas.com", "0854712101"));
        users.add(new User("User1", "1234", "user1@jhgfas.com", "0858172101"));
        users.add(new User("User2", "12345", "user2@jhgfas.com", "0845712101"));
        return users;
    }

    public void addUser(User user) {

        getAllUsers().add(user);

    }
}
