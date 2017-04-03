package listener;

import org.springframework.web.context.support.WebApplicationContextUtils;
import pojo.Goods;
import service.GoodsManagerImpl;

import javax.servlet.ServletContext;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DTLuc on 2017/4/1.
 */

public class AuctionListener {
    static private GoodsManagerImpl goodsManager;
    static private Goods goods;

    static public void run(ServletContext context){

        SimpleDateFormat dateformatAll= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("AuctionListener启动");
        goodsManager = WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean(GoodsManagerImpl.class);
        Integer cacheTime = 500;
        Timer timer = new Timer();
        // (TimerTask task, long delay, long period)任务，延迟时间，多久执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<?> goodsList = (List<?>) context.getAttribute("onSaleList");
                for(int i = 0; i < goodsList.size();i++){
                    goods = (Goods) goodsList.get(i);
                    System.out.println(dateformatAll.format(goods.getStart_time()));
                    System.out.println(dateformatAll.format(new Timestamp(System.currentTimeMillis())));
                    if(dateformatAll.format(goods.getStart_time()).equals(dateformatAll.format(new Timestamp(System.currentTimeMillis())))) {
                        goods.setState("在售");
                        goodsManager.updateGoodsInfo(goods);
                        goodsList.remove(i);
                    }
                }
            }
        }, 1000*10, cacheTime);
    }
}
