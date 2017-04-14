package action.auction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import pojo.Balance_log;
import service.AuctionLogManagerImpl;
import service.BalanceManagerImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dymond on 2017/4/14.
 */
@Controller
public class CheckMarginAction extends ActionSupport implements SessionAware {
    private String goods_id;
    private BalanceManagerImpl balanceManager;
    private Balance_log balance_log;
    private Map<String,Object> session;
    private Map<String,Object> dataMap;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public BalanceManagerImpl getBalanceManager() {
        return balanceManager;
    }

    public void setBalanceManager(BalanceManagerImpl balanceManager) {
        this.balanceManager = balanceManager;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Balance_log getBalance_log() {
        return balance_log;
    }

    public void setBalance_log(Balance_log balance_log) {
        this.balance_log = balance_log;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String json(){
        balance_log = new Balance_log();
//        int user_id = (int) session.get("USER_ID");
        int user_id = 1;//test
        balance_log.setUser_id(user_id);
        balance_log.setOperation_note(goods_id);
        dataMap = new HashMap<String,Object>();
        if(balanceManager.checkMargin(balance_log)){//检查是否交了押金
            dataMap.put("result","1");
        }else {
            dataMap.put("result","0");
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
