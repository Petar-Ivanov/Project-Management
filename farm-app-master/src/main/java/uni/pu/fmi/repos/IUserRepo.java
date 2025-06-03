package uni.pu.fmi.repos;

import uni.pu.fmi.models.User;

import java.util.List;

public interface IUserRepo {
    List<User> getAllUsers();
}
