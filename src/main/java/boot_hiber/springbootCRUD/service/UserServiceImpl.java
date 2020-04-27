package boot_hiber.springbootCRUD.service;



import boot_hiber.springbootCRUD.dao.UserDao;
import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private RoleDao roleDao;


    @Override
    public void addUser(User user) {
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDao.getRoleById(1L));
//        user.setRoles(roles);
        user.setRoles(Collections.singleton(new Role(1L)));
        userDao.addUser(user);
    }


    @Override
    public void updateUser(User user) {
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDao.getRoleById(1L));
//        user.setRoles(roles);
        user.setRoles(Collections.singleton(new Role(1L)));
        userDao.updateUser(user);
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


}



