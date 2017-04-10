package listener;

import org.springframework.web.context.support.WebApplicationContextUtils;
import pojo.Goods;
import service.AuctionProcessManagerImpl;
import service.GoodsManagerImpl;

import javax.servlet.ServletContext;
import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DTLuc on 2017/4/2.
 */
 public class OrderListener {
    private static Goods goods;
    private static GoodsManagerImpl goodsManager;
    private static AuctionProcessManagerImpl auctionProcessManager;
//    private static
    static public void run(ServletContext context){
        System.out.println("OrderListener启动");
        auctionProcessManager = WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean(AuctionProcessManagerImpl.class);
        goodsManager = WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean(GoodsManagerImpl.class);
        Integer cacheTime = 500;
        Timer timer = new Timer();
        // (TimerTask task, long delay, long period)任务，延迟时间，多久执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<?> finish_goods = (List<?>) context.getAttribute("GoodsList");
                for(int i = 0;i < finish_goods.size();i++){
                    goods = (Goods) finish_goods.get(i);
                    if (goods.getFinal_time().before(new Timestamp(System.currentTimeMillis()))){  //结束时间是否在现在时间之后
                        System.out.println("商品："+goods.getGoods_id()+"到时");
                        goods.setState("结束");  //商品状态修改为结束
                        goodsManager.updateGoodsState(goods);  //更新商品信息
                        auctionProcessManager.createOrder(goods);  //调用业务类进行创建新订单
                        finish_goods.remove(i);
                    }
                }
                if(finish_goods.size()==0)
                    timer.cancel();
            }

        }, 1000, cacheTime);
    }
}
