package daoImpl;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.AuctionDao;
import pojo.Auction;
import pojo.Goods;
import pojo.User;

import java.util.List;

@Repository
public class AuctionDaoImpl extends HibernateDaoSupport implements AuctionDao {

    @Override
    public List<?> findLog(User user, Goods goods) throws HibernateException {
        List<?> result = getHibernateTemplate().find("SELECT A FROM Auction A WHERE A.user_id = ?0 AND A.goods_id = ?1",
                new int[]{user.getUser_id(),goods.getGoods_id()});
        return result;
    }

    @Override
    public List<?> findGoodsLog(Goods goods) throws HibernateException {
        return null;
    }

    @Override
    public List<?> findMaxLog(Goods goods) throws HibernateException {
        List<?> result = getHibernateTemplate().find("SELECT max(A.price) FROM Auction A WHERE A.goods_id = ?0",goods.getGoods_id());
        return result;
    }

    @Override
    public Boolean saveLog(Auction auction) throws HibernateException {
        getHibernateTemplate().save(auction);
        return null;
    }
}
