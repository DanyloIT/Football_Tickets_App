package ticket_app.service;

import ticket_app.model.Role;

public interface RoleService {
    void add(Role role);
  
    Role getRoleByName(Role.RoleName roleName);
}
