package daoImpl;

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
            System.out.println("存入成功");
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
    public List<?> searchGoods(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        List<?> result;
        result = getHibernateTemplate().find("FROM Goods G WHERE G.create_user = ?0", goods.getCreate_user());
        return result;
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
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowTime);
        calendar.add(Calendar.HOUR,1);
        Timestamp final_time = new Timestamp(calendar.getTime().getTime());
        List<?> result = getHibernateTemplate().find("FROM Goods G WHERE G.final_time >= ?0 AND G.final_time <= ?1",
                new Timestamp[]{nowTime,final_time});
        return result;
    }

    @Override
    public List<?> searchOnsaleGoodsHour() throws HibernateException {
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowTime);
        calendar.add(Calendar.HOUR,1);
        Timestamp final_time = new Timestamp(calendar.getTime().getTime());
        List<?> result = getHibernateTemplate().find("FROM Goods G WHERE G.start_time >= ?0 AND G.start_time <= ?1",
                new Timestamp[]{nowTime,final_time});
        return result;
    }

}
