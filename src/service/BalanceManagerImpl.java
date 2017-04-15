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
    private UserDaoImpl userDao;


    public Balance_logDaoImpl getBalanceLogDao() {
        return balanceLogDao;
    }

    public void setBalanceLogDao(Balance_logDaoImpl balanceLogDao) {
        this.balanceLogDao = balanceLogDao;
    }


    @Override
    public boolean recharge(int user_id, double amount) throws HibernateException {
        User user = userDao.findUserById(user_id);
        user.setBalance(user.getBalance()+amount);
        userDao.updateObject(user);
        return true;
    }

    @Override
    public boolean reflect(int user_id, double amount) throws HibernateException {
        // TODO Auto-generated method stub
        User user = userDao.findUserById(user_id);
        if(user.getBalance()-amount<0)
            return false;
        else{
            user.setBalance(user.getBalance()-amount);
            userDao.updateObject(user);
            return true;
        }
    }

    @Override
    public boolean balanceLog(int user_id, double amount) throws HibernateException {
        Balance_log balance_log = new Balance_log();
        balance_log.setUser_id(user_id);
        balance_log.setAmount(amount);
        balance_log.setOperation_type("充值");
        balance_log.setOperation_note("充值:"+amount);
        balanceLogDao.saveBalance(balance_log);
        return true;
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
