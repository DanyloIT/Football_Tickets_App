package tickets.service;

import tickets.model.Role;

public interface RoleService {
    void add(Role role);
  
    Role getRoleByName(Role.RoleName roleName);
}
