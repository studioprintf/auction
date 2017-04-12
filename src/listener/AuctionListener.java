package listener;

import org.springframework.web.context.support.WebApplicationContextUtils;
import pojo.Goods;
import service.GoodsManagerImpl;

import javax.servlet.ServletContext;
import java.sql.Timestamp;
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
//                    if(dateformatAll.format(goods.getStart_time()).equals(dateformatAll.format(new Timestamp(System.currentTimeMillis())))) {
                    if(goods.getStart_time().before(new Timestamp(System.currentTimeMillis()))){
                        goods.setState("1");
                        goodsManager.updateGoodsState(goods);
                        goodsList.remove(i);
                    }
                }
                if(goodsList.size()==0)
                    timer.cancel();
            }
        }, 1000, cacheTime);
    }
}
