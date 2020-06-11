package boot_hiber.springbootCRUD.service;



import boot_hiber.springbootCRUD.dao.RoleDao;
import boot_hiber.springbootCRUD.dao.UserDao;
import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    @Override
    public void addUser(User user, String[] checkboxRoles)  {
        Set<Role> roles = new HashSet<>();
        parseRole(roles,checkboxRoles);
//        roles.add(roleDao.getRoleById(1L));
        user.setRoles(roles);
//        user.setRoles(Collections.singleton(new Role(1L)));
        userDao.addUser(user);
    }


    @Override
    public void updateUser(User user, String[] checkboxRoles) {
        Set<Role> roles = new HashSet<>();
        parseRole(roles,checkboxRoles);
        user.setRoles(roles);
        userDao.updateUser(user);

//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDao.getRoleById(1L));
//        user.setRoles(roles);
//        user.setRoles(Collections.singleton(new Role(1L)));
    }


    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }


    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

// Парсим массив строк с ролями
    public void parseRole(Set<Role>roles, String [] checkRoles){
        for (String checkRole:checkRoles){
            if (checkRole.equals("ROLE_ADMIN")){
                roles.add(roleDao.getRoleById(2L));
            }
            if (checkRole.equals("ROLE_USER")){
                roles.add(roleDao.getRoleById(1L));
            }
        }
    }

}



