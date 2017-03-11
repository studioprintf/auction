package daoImpl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import pojo.User;

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
	
}
