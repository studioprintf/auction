package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import pojo.User;

@Transactional()
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public UserDaoImpl() {
        System.out.println("UserDao IN");
    }
	
    public void saveObject(Object obj) throws HibernateException {
        getHibernateTemplate().save(obj);  
    }  

    public List<User> getUsers() throws HibernateException{
        List<User> users=getHibernateTemplate().loadAll(User.class);
        return users;
    }
    
    public User findUser(User user) throws HibernateException{
    	List list =getHibernateTemplate().find("FROM User U WHERE U.user_name = ?",user.getUser_name());
    	if(list.size()!=0)
    		return (User) list.get(0);
    	else
    		return null;
    }
	
}
