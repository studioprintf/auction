package action.goods;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import pojo.Goods;
import pojo.Goodsinfo;
import service.GoodsManagerImpl;

import java.util.Map;

/**
 * Created by DTLuc on 2017/3/31.
 */
@Controller
public class UserGetGoodsAction extends ActionSupport implements RequestAware{
    private String goods_id;
    private Map<String,Object> request;
    private GoodsManagerImpl goodsManager;
    private Goods goods;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public GoodsManagerImpl getGoodsManager() {
        return goodsManager;
    }

    public void setGoodsManager(GoodsManagerImpl goodsManager) {
        this.goodsManager = goodsManager;
    }

    @Override
    public String execute() throws Exception {
        goods = new Goods();
        goods.setGoods_id(Integer.parseInt(goods_id));
        try {
            Goods goodsSql = goodsManager.getGoods(goods);//获取商品信息
            Goodsinfo goodsInfo = goodsManager.getGoodsInfo(goods);//获取商品详细信息
            if(goodsInfo==null){//无此商品
                request.put("msg", "商品访问错误");
                request.put("url", "index");
                return ERROR;
            }
            request.put("Goods",goodsSql);
            request.put("GoodsInfo",goodsInfo);
        }
        catch (HibernateException h){
            request.put("msg", "商品访问错误");
            request.put("url", "index");
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }
}
