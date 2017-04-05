package action.user;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.HibernateException;
import pojo.Goods;
import pojo.Goodsinfo;
import service.GoodsManagerImpl;

import java.util.Map;

/**
 * Created by DTLuc on 2017/3/31.
 */
public class UserGetGoodsAction implements Action, RequestAware{
    private int goods_id;
    private Map<String,Object> request;
    private GoodsManagerImpl goodsManager;
    private Goods goods;
    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
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
        goods.setGoods_id(getGoods_id());
        try {
            Goodsinfo goodsInfo = goodsManager.getGoodsInfo(goods);
            request.put("Goods",goods);
            request.put("GoodInfo",goodsInfo);
        }
        catch (HibernateException h){
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }
}
