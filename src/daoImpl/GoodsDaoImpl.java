package daoImpl;

import dao.GoodsDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import pojo.Goods;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Repository
public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao {

    @Override
    public boolean saveGoods(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        try {
            getHibernateTemplate().save(goods);
            return true;
        } catch (HibernateException e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public List<?> getAll() throws HibernateException {
        // TODO Auto-generated method stub
        List<Goods> result = getHibernateTemplate().loadAll(Goods.class);
        return result;
    }

    @Override
    public List<?> searchGoodsByUser(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        List<?> result;
        result = getHibernateTemplate().find("FROM Goods G WHERE G.create_user = ?0", goods.getCreate_user());
        return result;
    }

    @Override
    public List<?> fingGoodsInfo(Goods goods) throws HibernateException {
        return getHibernateTemplate().find("FROM Goods G WHERE G.goods_id = ?0",goods.getGoods_id());
    }

    @Override
    public List<?> searchOnSale() throws HibernateException {
        return getHibernateTemplate().find("FROM Goods G WHERE G.state = '1'");
    }

    @Override
    public boolean updateGoods(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        try {
            getHibernateTemplate().update(goods);
            return true;
        } catch (HibernateException e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public List<?> searchGoodsHour() throws HibernateException {
        //查找在10分钟内结束的订单
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowTime);
        calendar.add(Calendar.MINUTE,10);
        Timestamp final_time = new Timestamp(calendar.getTime().getTime());
        List<?> result = getHibernateTemplate().find("FROM Goods G WHERE G.final_time >= ?0 AND G.final_time <= ?1",
                new Timestamp[]{nowTime,final_time});
        return result;
    }

    @Override
    public List<?> searchOnsaleGoodsHour() throws HibernateException {
        //查找在10分钟内开始的订单
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowTime);
        calendar.add(Calendar.MINUTE,10);
        Timestamp final_time = new Timestamp(calendar.getTime().getTime());
        List<?> result = getHibernateTemplate().find("FROM Goods G WHERE G.start_time >= ?0 AND G.start_time <= ?1",
                new Timestamp[]{nowTime,final_time});
        return result;
    }

    @Override//
    public List<?> checkState(Goods goods) throws HibernateException {
        List<?> state = getHibernateTemplate().find("Select G.state from Goods G where G.goods_id =?0",goods.getGoods_id());
        return state;
    }

    @Override
    public List<?> getGoodsList(int offset, int length) throws HibernateException {
        String hql= "select g.goods_id,g.state,g.create_time,g.start_time,g.final_time,gi.goods_title,gi.goods_image1, max(a.price)  from Goods g left join Goodsinfo gi on g.goods_id = gi.goods_id  left join Auction a on gi.goods_id = a.goods_id  group by a.goods_id,g.goods_id,g.state,g.create_time,g.start_time,g.final_time,gi.goods_title,gi.goods_image1 order by g.state asc , g.create_time desc";
        Session session = this.getSessionFactory().getCurrentSession();
        Query q = session.createQuery(hql);
        q.setFirstResult(offset * length);
        q.setMaxResults(length);
        List<?> list = q.list();
        return list;
    }

    @Override
    public List<?> getGoodsNum() throws HibernateException {
        List<?> num = getHibernateTemplate().find("Select count(G) from Goods G");
        return num;
    }

}
