package boot_hiber.springbootCRUD.dto;

import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;
import boot_hiber.springbootCRUD.repository.RoleRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    RoleRepository roleRepository;
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String idRole;



    public UserDto() {

    }

    //    public User dtoToUser(UserDto dto) {
//        User user = new User();
//        user.setId(dto.getId());
//        user.setUsername(dto.getUsername());
//        user.setPassword(dto.getPassword());
//        user.setAge(dto.getAge());
//        Set<Role> roles = new HashSet<>();
//        if (dto.getNameRole().equals("ROLE_ADMIN")) {
//            roles.add(roleRepository.getOne(2L));
//        } else {
//            roles.add(roleRepository.getOne(1L));
//        }
//        user.setRoles(roles);
//        return user;
//    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }
}
