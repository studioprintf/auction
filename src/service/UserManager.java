package service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import daoImpl.UserDaoImpl;
import pojo.User;


public class UserManager {
    private UserDaoImpl dao;  

    public UserManager(){
        dao = new UserDaoImpl();
        System.out.println("UserManager IN");
    }
    
    public UserDaoImpl getDao() {
    	return dao;
	}

    public void setDao(UserDaoImpl dao) {
        this.dao = dao;
    }

    public List<User> getUsers() throws HibernateException {  
        return dao.getUsers();
    }
    
    @Transactional
    public boolean register(User user) throws HibernateException{
    	dao.saveObject(user);
    	return true;
    }
    
    public boolean login(User user) throws HibernateException{
    	
    	return true;
    	
    }
	
}
