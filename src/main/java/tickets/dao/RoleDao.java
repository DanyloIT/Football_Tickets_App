package tickets.dao;

import java.util.Optional;
import tickets.model.Role;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(Role.RoleName roleName);
}
