package web.dao;

import web.models.Role;

import java.util.Set;


public interface RoleDao {

    public void save(Role role);

    public Role getRoleById(int id);
}
