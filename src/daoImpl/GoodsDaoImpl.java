package daoImpl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.GoodsDao;

@Repository
public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao {

}
