package boot_hiber.springbootCRUD.service;



import boot_hiber.springbootCRUD.dto.UserDto;
import boot_hiber.springbootCRUD.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    void addUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void removeUser(Long idRole);

    User getUserById(Long id);

    List<User> listUsers();

}
