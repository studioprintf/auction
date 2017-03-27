package daoImpl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.AuctionDao;

@Repository
public class AuctionDaoImpl extends HibernateDaoSupport implements AuctionDao {

}
