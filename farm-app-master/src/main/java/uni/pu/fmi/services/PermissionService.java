package uni.pu.fmi.services;

public class PermissionService {

    public boolean canChangeProjectRoles(String roleTitle){
        return roleTitle.equals("Project Manager") || roleTitle.equals("Developer");
    }

}
