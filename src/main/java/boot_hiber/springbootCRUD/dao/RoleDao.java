package boot_hiber.springbootCRUD.dao;


import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;

public interface RoleDao {
    User getUserByUsername(String username);
    Role getRoleById(Long id);


}
