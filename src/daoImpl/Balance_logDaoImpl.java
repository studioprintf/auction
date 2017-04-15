package daoImpl;

import dao.Balance_logDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import pojo.Balance_log;
import pojo.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class Balance_logDaoImpl extends HibernateDaoSupport implements Balance_logDao {


    @Override//查询用户余额
    public double checkBalance(User user) throws HibernateException {
        List<?> list = getHibernateTemplate().find("Select U.balance from  User U where U.user_id=?", user.getUser_id());
        if (list.size() != 0) {
            return Double.parseDouble((String) list.get(0));
        } else
            return 0;
    }

    @Override
    public boolean saveBalance(Balance_log balance_log) throws HibernateException {
        try{
            getHibernateTemplate().save(balance_log);
        }
        catch (HibernateException h){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkMargin(Balance_log balance_log) throws HibernateException {
        List<?> list = getHibernateTemplate().find("SELECT B from Balance_log B where B.user_id =?0 and B.operation_note = ?1",balance_log.getUser_id(),balance_log.getOperation_note());
        if(!list.isEmpty()){
            return true;//已经缴纳押金
        }
        return false;
    }

    @Override//冻结押金
    public String toMargin(Balance_log balance_log) throws HibernateException {
        if(checkMargin(balance_log)) {//已经缴纳押金
            return "已经缴纳押金";
        }
        List<?> list = getHibernateTemplate().find("Select U from  User U where U.user_id=?", balance_log.getUser_id());
        if (list.size() != 0) {
            User userSql = (User) list.get(0);
            if (userSql.getBalance() > balance_log.getAmount()) {
                String hql1 = "Update User U set U.balance= (U.balance - ?0) Where U.user_id = ?1";
                String hql2 = "Update User U set U.frozen_amount = (U.frozen_amount + ?0) where U.user_id = ?1";
                Session session = this.getSessionFactory().getCurrentSession();
                Query query1 = session.createQuery(hql1);
                query1.setParameter(0, balance_log.getAmount());
                query1.setParameter(1, balance_log.getUser_id());
                query1.executeUpdate();
                Query query2 = session.createQuery(hql2);
                query2.setParameter(0,balance_log.getAmount());
                query2.setParameter(1,balance_log.getUser_id());
                query2.executeUpdate();

                getHibernateTemplate().save(balance_log);
                return "success";
            } else {
                return "余额不足,请先充值";
            }

        } else {
            return "";
        }

    }


}
