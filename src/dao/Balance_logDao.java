package dao;

import org.hibernate.HibernateException;
import pojo.Balance_log;
import pojo.User;

import java.util.List;


public interface Balance_logDao {

    //查询押金是否缴纳
    public Boolean checkMargin(Balance_log balance_log) throws HibernateException;

    //冻结押金
    public String toMargin(Balance_log balance_log) throws HibernateException;

    //查询余额
    public double checkBalance(User user) throws HibernateException ;


}
