package daoImpl;

import dao.AuctionDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
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
        List<?> result = getHibernateTemplate().find(
                "FROM Auction AU WHERE AU.goods_id = ?0 AND AU.price = (SELECT max(A.price) FROM Auction A WHERE A.goods_id = ?0)",
                goods.getGoods_id());
        return result;
    }

    @Override
    public Boolean saveLog(Auction auction) throws HibernateException {
        getHibernateTemplate().save(auction);
        return true;
    }

    @Override //获取对应商品的出价记录数
    public int getBidsNum(Goods goods) throws HibernateException {
        List<Long> result = (List<Long>) getHibernateTemplate().find("SELECT count(*) FROM Auction A WHERE A.goods_id = ?0", goods.getGoods_id());
        if (!result.isEmpty()) {
            return Integer.parseInt(String.valueOf(result.get(0)));
        }
        return 0;
    }



    @Override//分页获取出价记录
    public List<?> getBids(String goods_id, int offset, int length) throws HibernateException {
        String hql = "Select A FROM Auction A WHERE A.goods_id = ?0 order by A.price desc";
        Session session = this.getSessionFactory().getCurrentSession();
        Query q = session.createQuery(hql).setParameter(0, Integer.parseInt(goods_id));
        q.setFirstResult(offset * length);//开始记录
        q.setMaxResults(length);//一次查询几条记录
        if(q.list()==null)
            return null;
        List<?> list = q.list();
//        session.close();//出现回滚错误
        return list;
    }

    @Override//根据goods_id获取出价记录
    public List<?> getBidList(String goods_id) throws HibernateException {
        List<?> list = getHibernateTemplate().find("select A from Auction A where A.goods_id = ?0 order by A.price desc");
        return list;
    }



}
