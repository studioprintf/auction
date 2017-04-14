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
    //��ֵ
    public boolean recharge(User user, Double amount) throws HibernateException;

    //����
    public boolean reflect(User user, Double amount) throws HibernateException;

    //查询用户余额
    public double checkBalance(User user) throws HibernateException;

    //冻结资金
    public String toMargin(Balance_log balance_log) throws HibernateException;

    //检查是否交了押金
    public boolean checkMargin(Balance_log balance_log) throws HibernateException;

}
