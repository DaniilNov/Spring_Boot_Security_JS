package boot_hiber.springbootCRUD.service;



import boot_hiber.springbootCRUD.model.User;

import java.util.List;

public interface UserService{
    void addUser(User user, String[] checkboxRoles);

    void updateUser(User user, String[] checkboxRoles);

    void removeUser(Long id);

    User getUserById(Long id);

    List<User> listUsers();

}
