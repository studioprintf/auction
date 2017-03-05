package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.UserDao;
import pojo.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public List<User> getUser() throws HibernateException{
		List<User> users=getHibernateTemplate().loadAll(User.class);
        return users;
	}
	
}
