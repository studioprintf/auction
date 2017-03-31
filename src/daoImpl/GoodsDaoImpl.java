package daoImpl;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

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
    public List<?> searchGoods(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        List<?> result;
        result = getHibernateTemplate().find("FROM Goods G WHERE G.create_user = ?0", goods.getGoods_id());
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

}
