package action.seller;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import pojo.Goods;
import service.GoodsManagerImpl;

import java.util.Map;

/**
 * Created by DTLuc on 2017/4/6.
 */
public class SellerFindGoodsAction implements Action, SessionAware, RequestAware{
    private Map<String,Object> session;
    private Map<String,Object> request;
    private GoodsManagerImpl goodsManager;

    public void setGoodsManager(GoodsManagerImpl goodsManager) {
        this.goodsManager = goodsManager;
    }

    @Override
    public String execute() throws Exception {
        int user_id = Integer.parseInt(session.get("USER_ID").toString());
        Goods goods = new Goods();
        goods.setCreate_user(user_id);
        request.put("USER_GOODS",goodsManager.userOnSaleGoods(goods));
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }
}
