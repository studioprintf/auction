package dao;

import org.hibernate.HibernateException;
import pojo.Order;

public interface OrderDao {
    boolean saveOrder(Order order) throws HibernateException;
}
