package tickets.service.impl;

import org.springframework.stereotype.Service;
import tickets.dao.RoleDao;
import tickets.exception.DataProcessingException;
import tickets.model.Role;
import tickets.service.RoleService;

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
                () -> new DataProcessingException("Can't find role with name " + roleName));
    }
}
