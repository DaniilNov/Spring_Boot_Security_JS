package boot_hiber.springbootCRUD.service;


import boot_hiber.springbootCRUD.model.User;
import boot_hiber.springbootCRUD.repository.RoleRepository;
import boot_hiber.springbootCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("User is not found");
        }
        return user;
    }
}
