package service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import daoImpl.UserDaoImpl;
import pojo.User;


public class UserManagerImpl implements UserManager{
    private UserDaoImpl dao;  

    public UserManagerImpl(){
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
    
    public boolean register(User user) throws HibernateException{
    	dao.saveObject(user);
    	return true;
    }
    
    public String login(User user) throws HibernateException{
    	User user1 = dao.findUser(user);
    	if(user1!=null)
    		if(user1.getUser_password().equals(user.getUser_password()))
    			return "success";
    		else
    			return "error";
    	else
    		return "null";
    }
	
}
