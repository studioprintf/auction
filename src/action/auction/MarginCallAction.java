package action.auction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import pojo.Balance_log;
import pojo.Goods;
import pojo.User;
import service.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dymond on 2017/4/13.
 */
@Controller
public class MarginCallAction extends ActionSupport implements SessionAware{
    private BalanceManagerImpl balanceManager;
    private GoodsManagerImpl goodsManager;

    private Goods goods;
    private Balance_log balance_log;
    private Map<String,Object> session;
    private Map<String,Object> dataMap;

    private String goods_id;

    public BalanceManagerImpl getBalanceManager() {
        return balanceManager;
    }

    public void setBalanceManager(BalanceManagerImpl balanceManager) {
        this.balanceManager = balanceManager;
    }

    public GoodsManagerImpl getGoodsManager() {
        return goodsManager;
    }

    public void setGoodsManager(GoodsManagerImpl goodsManager) {
        this.goodsManager = goodsManager;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }


    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public Balance_log getBalance_log() {
        return balance_log;
    }

    public void setBalance_log(Balance_log balance_log) {
        this.balance_log = balance_log;
    }


    public Map<String, Object> getSession() {
        return session;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String json(){
        dataMap = new HashMap<String,Object>();
        if (!(session.get("USER_NAME") != null && session.get("USER_ID") != null)) {
            return NONE;
        }
        int user_id = (int) session.get("USER_ID");//test

        //查询当前商品是否在售
        goods = new Goods();
        goods.setGoods_id(Integer.parseInt(goods_id));
        Goods goodsSql = goodsManager.getGoods(goods);
        String state = goodsSql.getState();
        if(!(state.equals("1"))){//非在售商品
            dataMap.put("HasError", "1");
            dataMap.put("Message","非在售商品不能参与！");
        }else {

            balance_log = new Balance_log();

            //开始冻结押金
            balance_log.setUser_id(user_id);
            balance_log.setOperation_type("margin");
            balance_log.setOperation_note(goods_id);
            balance_log.setAmount(goodsSql.getReserve_price());
            String result = balanceManager.toMargin(balance_log);
            if (result=="success") {
                dataMap.put("HasError", "0");
            } else {
                System.out.println("冻结押金失败");
                dataMap.put("HasError", "1");
                dataMap.put("Message",result);
            }
        }
        return SUCCESS;

    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
