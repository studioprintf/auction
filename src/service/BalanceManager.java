package service;

import org.hibernate.HibernateException;

import pojo.Balance_log;
import pojo.User;

/**
 * ������ģ��
 *
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����9:17:17
 * @parameter
 * @return
 */
public interface BalanceManager {
    //充值
    boolean recharge(int user_id, double amount) throws HibernateException;

    //提现
    boolean reflect(int user_id, double amount) throws HibernateException;

    //充值记录
    boolean balanceLog(int user_id, double amount) throws HibernateException;

    //查询用户余额
    double checkBalance(User user) throws HibernateException;

    //冻结资金
    String toMargin(Balance_log balance_log) throws HibernateException;

    //检查是否交了押金
    boolean checkMargin(Balance_log balance_log) throws HibernateException;

}
