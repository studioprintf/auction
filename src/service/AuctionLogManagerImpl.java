package service;

import java.util.List;

import daoImpl.AuctionDaoImpl;
import daoImpl.Balance_logDaoImpl;
import org.hibernate.HibernateException;
import pojo.Balance_log;
import pojo.Goods;
import pojo.User;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����9:19:57
 * @parameter
 * @return
 */
public class AuctionLogManagerImpl implements AuctionLogManager {
    private Balance_logDaoImpl balanceLogDao;


    public Balance_logDaoImpl getBalanceLogDao() {
        return balanceLogDao;
    }


    public void setBalanceLogDao(Balance_logDaoImpl balanceLogDao) {
        this.balanceLogDao = balanceLogDao;
    }

    @Override
    public List<?> getAuctionLog() throws HibernateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> getUserAuciton() throws HibernateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> getUserSuccess() throws HibernateException {
        // TODO Auto-generated method stub
        return null;
    }


}
