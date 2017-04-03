package daoImpl;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.User_orderDao;
import pojo.User_order;

import java.util.List;

@Repository
public class User_orderDaoImpl extends HibernateDaoSupport implements User_orderDao {

    @Override
    public boolean saveOrder(User_order order) throws HibernateException {
        getHibernateTemplate().save(order);
        return true;
    }

    @Override
    public List<?> getOrder() throws HibernateException {
        return getHibernateTemplate().loadAll(User_order.class);
    }
}
