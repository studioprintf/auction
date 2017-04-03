package listener;

import daoImpl.GoodsDaoImpl;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DTLuc on 2017/4/2.
 */
 public class OrderListener {

    static public void run(ServletContext context){
        System.out.println("OrderListener启动");
//        ServletContext context = sce.getServletContext();
//        GoodsDaoImpl goodsDao = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext()).getBean(GoodsDaoImpl.class);
        Integer cacheTime = 500;
        Timer timer = new Timer();
        // (TimerTask task, long delay, long period)任务，延迟时间，多久执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<?> finish_goods = (List<?>) context.getAttribute("GoodsList");
            }
        }, 1000 * 10, cacheTime);
    }
}
