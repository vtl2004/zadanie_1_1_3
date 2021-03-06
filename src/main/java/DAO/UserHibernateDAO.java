package DAO;

import model.User;
//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Conjunction;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Restrictions;

import service.UserService;
import util.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO{
    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    private static UserHibernateDAO userHibernateDAO;
    public static UserHibernateDAO getInstance(){
        if (userHibernateDAO == null){
            userHibernateDAO = new UserHibernateDAO(HibernateSessionFactoryUtil
            .getSessionFactory().openSession());
        }
        return userHibernateDAO;
    }


    @Override
    public List<User> findAllUsers() {
        List<User> users = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void saveUser(User user) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public User findUser(long id) throws SQLException {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
