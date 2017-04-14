package daoImpl;

import org.apache.struts2.components.Select;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import dao.GoodsDao;
import pojo.Goods;

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

}
