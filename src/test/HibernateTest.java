package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import pojo.User;
import service.UserManager;

public class HibernateTest {

    public static void main(String[] args) {
        //读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration().configure();  

        //建立SessionFactory  
        SessionFactory factory = cfg.buildSessionFactory();  

        //取得session  
        Session session = null;  
        try {  
            session = factory.openSession();  
            //开启事务  
            session.beginTransaction();  
            User user = new User();  
            user.setUser_name("zzw"); 
            user.setUser_password("zzw");  
            user.setUser_email("123@qq.com");
            user.setUser_type(1);
            user.setRegister_time(new Timestamp(new Date().getTime()));
            user.setSign_time(new Timestamp(new Date().getTime()));
            user.setSign_ip("127.0.0.1");
            //保存User对象  
            session.save(user);   
            String hql = "from User";  
            Query query = session.createQuery(hql);  
            List<User> roles = query.list();
            for(int i=0;i<roles.size();i++){
                System.out.print("从数据库加载数据的用户名为"+roles.get(i).getUser_name());  
            }
            //提交事务  
            session.getTransaction().commit();  
        }catch(Exception e) {  
            e.printStackTrace();  
            //回滚事务  
            session.getTransaction().rollback();  
        }finally {  
            if (session != null) {  
                if (session.isOpen()) {  
                    //关闭session  
                    session.close();  
                }  
            }  
        }  

    }

}