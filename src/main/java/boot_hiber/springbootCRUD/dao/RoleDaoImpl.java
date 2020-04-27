package boot_hiber.springbootCRUD.dao;


import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    //    @Autowired
//    SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByUsername(String username) {
        User user = null;
//       Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("FROM User WHERE username =:username");
        Query query = (Query) entityManager.createQuery("FROM User WHERE username =:username");
        query.setParameter("username", username);
        user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public Role getRoleById(Long id) {
//        return sessionFactory.getCurrentSession().get(Role.class,id);
        return entityManager.find(Role.class, id);
    }

//    public Role getRoleByUserId(Long id){
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createNativeQuery("select roles_id from users_role where users_id =id;");
//
//    }
}
