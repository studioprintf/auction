package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import pojo.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public UserDaoImpl() {
        System.out.println("UserDao IN");
    }

    public void saveObject(User obj) throws HibernateException {
        getHibernateTemplate().save(obj);

    }

    public List<User> getUsers() throws HibernateException {
        System.out.printf("Test");
        List<User> users = getHibernateTemplate().loadAll(User.class);
        return users;
    }

    public User findUser(User user) throws HibernateException {
        List<?> list = getHibernateTemplate().find("Select U FROM User U WHERE U.user_name = ?", user.getUser_name());
        if (list.size() != 0)
            return (User) list.get(0);
        else
            return null;
    }



    @Override
    public User findUserByName(String userName) throws HibernateException {
        List<?> list = getHibernateTemplate().find("Select U FROM User U WHERE U.user_name = ?", userName);
        if (list.size() != 0) {
            return (User) list.get(0);
        } else
            return null;
    }




    public void updateObject(User user) throws HibernateException {
        getHibernateTemplate().update(user);

    }


}

