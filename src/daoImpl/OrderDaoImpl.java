package daoImpl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.OrderDao;
@Repository
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

}
