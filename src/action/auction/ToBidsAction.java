package action.auction;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import pojo.Auction;
import pojo.Balance_log;
import pojo.Goods;
import pojo.User;
import service.AuctionProcessManagerImpl;
import service.BalanceManagerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 *
 *
 * *   出价
 *
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����4:32:02
 * @parameter
 * @return
 */

@Controller
public class ToBidsAction implements Action, SessionAware {
    private int goods_id;
    private Map<String, Object> session;
    private double price;

    private String id;//json
    private String amt;//json
    private InputStream inputStream;

    private AuctionProcessManagerImpl auctionProcessManager;
    private BalanceManagerImpl balanceManager;

    private User user;
    private Goods goods;
    private Auction auction;
    private Balance_log balance_log;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public AuctionProcessManagerImpl getAuctionProcessManager() {
        return auctionProcessManager;
    }

    public void setAuctionProcessManager(AuctionProcessManagerImpl auctionProcessManager) {
        this.auctionProcessManager = auctionProcessManager;
    }


    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }


    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        setGoods_id(Integer.parseInt(getId()));
        setPrice(Double.parseDouble(getAmt()));

        user = new User();
        goods = new Goods();
        auction = new Auction();
        balance_log = new Balance_log();

        String user_name = "dymond";//test
        int user_id = 1;//test

//        int user_id = Integer.parseInt((String)session.get("USER_ID"));
//        String user_name = session.get("USER_NAME");

        user.setUser_name(user_name);//test
        user.setUser_id(user_id);
        goods.setGoods_id(goods_id);
        balance_log.setUser_id(user_id);
        balance_log.setOperation_note(String.valueOf(goods_id));
        if (!balanceManager.checkMargin(balance_log)) {
            //判断是否缴纳保证金
            inputStream = new ByteArrayInputStream("请先缴纳押金！".getBytes("UTF-8"));
            return SUCCESS;
        } else {
            auction.setGoods_id(goods_id);
            auction.setPrice(price);
            if (auctionProcessManager.joinAuction(user, goods, auction)) {
                inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
            } else {
                inputStream = new ByteArrayInputStream("出价失败！".getBytes("UTF-8"));
            }
//        }
            return SUCCESS;
        }


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

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Balance_log getBalance_log() {
        return balance_log;
    }

    public void setBalance_log(Balance_log balance_log) {
        this.balance_log = balance_log;
    }
}
