package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.GoodsinfoDao;
import pojo.Goods;
import pojo.Goodsinfo;

@Repository
public class GoodsinfoDaoImpl extends HibernateDaoSupport implements GoodsinfoDao {

    @Override
    public List<?> getGoodsInfo(Goodsinfo goodsinfo) throws HibernateException {
        List<?> result = getHibernateTemplate().find("FROM Goodsinfo G WHERE G.goods_title like '%?%' ", goodsinfo.getGoods_title());
        return result;
    }

    @Override
    public Boolean saveInfo(Goodsinfo goodsinfo) throws HibernateException {
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

}
