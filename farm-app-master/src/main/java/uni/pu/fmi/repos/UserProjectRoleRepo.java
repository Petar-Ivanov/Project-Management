package uni.pu.fmi.repos;

import uni.pu.fmi.models.UserProjectRole;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserProjectRoleRepo implements IUserProjectRoleRepo{
    @Override
    public List<UserProjectRole> getAllUserProjectRoles() {
        ArrayList<UserProjectRole> userProjectRoles = new ArrayList<>();

        UserProjectRole userProjectRole = new UserProjectRole(
                "User",
                "Project",
                "Project Manager",
                LocalDateTime.now()
        );

        UserProjectRole userProjectRole1 = new UserProjectRole(
                "User1",
                "Project1",
                "Project Manager",
                LocalDateTime.now()
        );

        UserProjectRole userProjectRole2 = new UserProjectRole(
                "User2",
                "Project2",
                "Project Manager",
                LocalDateTime.now()
        );

        UserProjectRole userProjectRole3 = new UserProjectRole(
                "User",
                "Project1",
                "Developer",
                LocalDateTime.now()
        );

        UserProjectRole userProjectRole4 = new UserProjectRole(
                "User",
                "Project2",
                "Observer",
                LocalDateTime.now()
        );


        userProjectRoles.add(userProjectRole);
        userProjectRoles.add(userProjectRole1);
        userProjectRoles.add(userProjectRole2);
        userProjectRoles.add(userProjectRole3);
        userProjectRoles.add(userProjectRole4);

        return userProjectRoles;
    }

    public void addUserProjectRole(UserProjectRole userProjectRole) {
        getAllUserProjectRoles().add(userProjectRole);
    }
}
