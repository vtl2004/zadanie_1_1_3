package service;

import DAO.UserHibernateDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSessionFactoryUtil;


import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserHibernateDAO usersDao = UserHibernateDAO.getInstance();

   private static UserService userService;
   public static UserService getInstance(){
       if (userService == null){
           userService = new UserService();
       }
       return userService;
   }

    public User findUser(int id) throws SQLException {
        return usersDao.findUser(id);
    }

    public void saveUser(User user) throws SQLException {
        usersDao.saveUser(user);
    }

    public void deleteUser(User user) throws SQLException {
        usersDao.deleteUser(user);
    }

    public void updateUser(User user) throws SQLException {
        usersDao.updateUser(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAllUsers();
    }
}
