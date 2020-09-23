package boot_hiber.springbootCRUD.repository;

import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Long> {

}
