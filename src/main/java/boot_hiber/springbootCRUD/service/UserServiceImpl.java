package boot_hiber.springbootCRUD.service;


import boot_hiber.springbootCRUD.dto.UserDto;
import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;
import boot_hiber.springbootCRUD.repository.RoleRepository;
import boot_hiber.springbootCRUD.repository.UserRepository;
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
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void addUser(UserDto userDto) {
        User user = new User(userDto.getUsername(),userDto.getPassword(),userDto.getAge());
        Set<Role> roles = new HashSet<>();
        if (userDto.getIdRole().equals("2")){
            roles.add(roleRepository.getOne(2L));
        }
        else {
            roles.add(roleRepository.getOne(1L));
        }
        user.setRoles(roles);
        userRepository.save(user);
    }
//    public void addUser(User user, String idRole) {
//        Set<Role> roles = new HashSet<>();
//        if (idRole.equals("2")){
//            roles.add(roleRepository.getOne(2L));
//        }
//        else {
//            roles.add(roleRepository.getOne(1L));
//        }
//        user.setRoles(roles);
//        userRepository.save(user);
//    }


    @Override
    public void updateUser(UserDto userDto) {
        User user = getUserById(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAge(userDto.getAge());
        Set<Role> roles = new HashSet<>();
        if (userDto.getIdRole().equals("2")){
            roles.add(roleRepository.getOne(2L));
        }
        else {
            roles.add(roleRepository.getOne(1L));
        }
        user.setRoles(roles);
        userRepository.save(user);
    }

//    public void updateUser(User user, String idRole) {
//        Set<Role> roles = new HashSet<>();
//       if (idRole.equals("2")){
//           roles.add(roleRepository.getOne(2L));
//       }
//       else {
//           roles.add(roleRepository.getOne(1L));
//       }
//       user.setRoles(roles);
//        userRepository.save(user);}



    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    // Парсим массив строк с ролями. Пока не пригодился.
    public void parseRole(Set<Role> roles, String[] checkRoles) {
        for (String checkRole : checkRoles) {
            if (checkRole.equals("ROLE_ADMIN")) {
                roles.add(roleRepository.getOne(2L));
            }
            if (checkRole.equals("ROLE_USER")) {
                roles.add(roleRepository.getOne(1L));
            }
        }
    }

}



