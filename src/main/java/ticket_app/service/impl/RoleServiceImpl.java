package ticket_app.service.impl;

import org.springframework.stereotype.Service;
import ticket_app.dao.RoleDao;
import ticket_app.exception.DataProcessingException;
import ticket_app.model.Role;
import ticket_app.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(
                () -> new DataProcessingException("Role with name " + roleName + " not found"));
    }
}
