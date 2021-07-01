package ticket_app.dao;

import ticket_app.model.Role;

import java.util.Optional;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(Role.RoleName roleName);
}
