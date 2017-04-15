package dao;

import org.hibernate.HibernateException;
import pojo.Balance_log;
import pojo.User;

import java.util.List;


public interface Balance_logDao {

    //查询押金是否缴纳
    Boolean checkMargin(Balance_log balance_log) throws HibernateException;

    //冻结押金
    String toMargin(Balance_log balance_log) throws HibernateException;

    //查询余额
    double checkBalance(User user) throws HibernateException ;

    //新增一条记录
    boolean saveBalance(Balance_log balance_log) throws HibernateException;
}
