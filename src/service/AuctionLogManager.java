package service;

import java.util.List;

import org.hibernate.HibernateException;
import pojo.Balance_log;
import pojo.Goods;
import pojo.User;

/**
 * ������¼����
 *
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����9:11:34
 * @parameter
 * @return
 */
public interface AuctionLogManager {
    //�鿴���ۼ�¼
    public List<?> getAuctionLog() throws HibernateException;

    //�鿴�û�����������
    public List<?> getUserAuciton() throws HibernateException;

    //�û��鿴�ñ������
    public List<?> getUserSuccess() throws HibernateException;


}
