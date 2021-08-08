package web.service;

import web.models.Role;

import java.util.Set;

public interface RoleService {

    public void save(Role role);

    public Role getRoleById(int id);
}
