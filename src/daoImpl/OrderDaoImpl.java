package daoImpl;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.OrderDao;
import pojo.Order;

@Repository
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

    @Override
    public boolean saveOrder(Order order) throws HibernateException {
        getHibernateTemplate().save(order);
        return true;
    }
}
