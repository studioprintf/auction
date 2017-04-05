package dao;

import org.hibernate.HibernateException;
import pojo.User_order;

import java.util.List;

public interface User_orderDao {
    boolean saveOrder(User_order order) throws HibernateException;
    List<?> getOrder() throws  HibernateException;
}
