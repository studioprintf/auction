package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.User;

public interface UserDao {
	
    public void saveObject(Object obj) throws HibernateException;

    public List<User> getUsers() throws HibernateException;

}
