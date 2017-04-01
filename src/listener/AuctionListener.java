package listener;

import daoImpl.AuctionDaoImpl;
import daoImpl.GoodsDaoImpl;
import daoImpl.OrderDaoImpl;
import pojo.Goods;
import service.GoodsManagerImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DTLuc on 2017/4/1.
 */

@WebListener
public class AuctionListener implements ServletContextListener {
    private AuctionDaoImpl auctionDao;
    private OrderDaoImpl orderDao;
    private GoodsDaoImpl goodsDao;
    private List<?> onTimeGoods;

    public GoodsDaoImpl getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDaoImpl goodsDao) {
        this.goodsDao = goodsDao;
    }

    public List<?> getOnTimeGoods() {
        return onTimeGoods;
    }

    public void setOnTimeGoods(List<?> onTimeGoods) {
        this.onTimeGoods = onTimeGoods;
    }

    public AuctionDaoImpl getAuctionDao() {
        return auctionDao;
    }

    public void setAuctionDao(AuctionDaoImpl auctionDao) {
        this.auctionDao = auctionDao;
    }

    public OrderDaoImpl getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDaoImpl orderDao) {
        this.orderDao = orderDao;
    }

    public void contextInitialized(ServletContextEvent sce){
        ServletContext context = sce.getServletContext();
        System.out.printf("AuctionListener启动");
        Integer cacheTime = 1000 * 3;
        Timer timer = new Timer();
        // (TimerTask task, long delay, long period)任务，延迟时间，多久执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 1000, cacheTime);
    }

}
