package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.GoodsinfoDao;
import pojo.Goods;
import pojo.Goodsinfo;

@Repository
public class GoodsinfoDaoImpl extends HibernateDaoSupport implements GoodsinfoDao {

    @Override
    public List<?> getGoodsNum(String searchKey) throws HibernateException {
        return getHibernateTemplate().find("SELECT COUNT(*) FROM Goodsinfo G WHERE G.goods_title like '%" + searchKey + "%' ");
    }

    @Override
    public List<?> getGoodsInfo(String searchKey,int index) throws HibernateException {
//        getHibernateTemplate().find("FROM Goodsinfo G WHERE G.goods_title like '%?0%' LIMIT ?1 , 10 " , new Object[]{searchKey,index*10});
//        HQL不支持Limit
        String hql = "FROM Goodsinfo G WHERE G.goods_title like '%" + searchKey + "%'";
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        query.setFirstResult(index*10);  //设置开始
        query.setMaxResults(10);  //最大条目为10
        List<?> result = query.list();
        return result;
    }

    @Override
    public boolean saveInfo(Goodsinfo goodsinfo) throws HibernateException {
        // TODO Auto-generated method stub
        getHibernateTemplate().save(goodsinfo);
        return true;
    }



    @Override
    public Goodsinfo findGoodsInfo(Goods goods) throws HibernateException {
        List<?> result = getHibernateTemplate().find("FROM Goodsinfo G WHERE G.goods_id = ?0",goods.getGoods_id());
        if(result.size()!=0)
            return (Goodsinfo) result.get(0);
        return  null;
    }

    @Override
    public boolean updateInfo(Goodsinfo goodsinfo) throws HibernateException {
        try {
            getHibernateTemplate().update(goodsinfo);
            return true;
        }
        catch (HibernateException h){

        }
        return false;
    }

}
