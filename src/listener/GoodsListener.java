package listener;

import daoImpl.GoodsDaoImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Created by DTLuc on 2017/4/1.
 */

public class GoodsListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("GoodsListener启动");
        ServletContext context = sce.getServletContext();
        GoodsDaoImpl goodsDao = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext()).getBean(GoodsDaoImpl.class);
        Integer cacheTime = 1000 * 60 * 10; //每十分钟执行一次
        Timer timer = new Timer();
        // (TimerTask task, long delay, long period)任务，延迟时间，多久执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List <?> goodsList = goodsDao.searchGoodsHour();
                List <?> onSaleList = goodsDao.searchOnsaleGoodsHour();
                System.out.println("将要完成的商品个数为"+goodsList.size());
                System.out.println("将要上架的商品个数为"+onSaleList.size());
                context.setAttribute("GoodsList",goodsList);
                context.setAttribute("onSaleList",onSaleList);
                OrderListener.run(context);
                AuctionListener.run(context);
            }
        }, 1000, cacheTime);
    }
}
