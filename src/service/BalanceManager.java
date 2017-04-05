package service;

import org.hibernate.HibernateException;

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
}
