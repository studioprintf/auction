package service;

import daoImpl.Balance_logDaoImpl;
import daoImpl.UserDaoImpl;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import pojo.Balance_log;
import pojo.User;

import java.util.List;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����9:22:22
 * @parameter
 * @return
 */
@Service
public class BalanceManagerImpl implements BalanceManager {
    private Balance_logDaoImpl balanceLogDao;



    public Balance_logDaoImpl getBalanceLogDao() {
        return balanceLogDao;
    }

    public void setBalanceLogDao(Balance_logDaoImpl balanceLogDao) {
        this.balanceLogDao = balanceLogDao;
    }


    @Override
    public boolean recharge(User user, Double amount) throws HibernateException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean reflect(User user, Double amount) throws HibernateException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override//查询用户余额
    public double checkBalance(User user) throws HibernateException {
        return balanceLogDao.checkBalance(user);
    }

    @Override//冻结资金
    public String toMargin(Balance_log balance_log) throws HibernateException {
        return balanceLogDao.toMargin(balance_log);
    }

    @Override//检查是否交了押金
    public boolean checkMargin(Balance_log balance_log) throws HibernateException {
        return balanceLogDao.checkMargin(balance_log);
    }


}
