package service;

import java.util.List;

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
	
}
