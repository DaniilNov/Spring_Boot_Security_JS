package boot_hiber.springbootCRUD.service;


import boot_hiber.springbootCRUD.dao.RoleDao;
import boot_hiber.springbootCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    RoleDao roleDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = roleDao.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("User is not found");
        }
        return user;
    }
}
