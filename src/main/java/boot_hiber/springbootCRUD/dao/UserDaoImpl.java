package boot_hiber.springbootCRUD.dao;

import boot_hiber.springbootCRUD.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void removeUser(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User getUserById(Long id) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();


        return userList;
    }
}

