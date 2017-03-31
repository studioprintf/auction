package action.user;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import pojo.Auction;
import pojo.Goods;
import pojo.User;
import service.AuctionProcessManagerImpl;

import java.util.Map;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����4:32:02
 * @parameter
 * @return
 */

@Controller
public class UserAuctionAction implements Action, SessionAware{
    private int goods_id;
    private Map<String,Object> seesion;
    private double price;

    private User user;
    private Goods goods;
    private Auction auction;

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

    private AuctionProcessManagerImpl auctionProcessManager;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public Map<String, Object> getSeesion() {
        return seesion;
    }

    public void setSeesion(Map<String, Object> seesion) {
        this.seesion = seesion;
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
        user = new User();
        goods = new Goods();
        auction = new Auction();
        user.setUser_id(Integer.parseInt(seesion.get("USER_ID").toString()));
        goods.setGoods_id(getGoods_id());
        if(auctionProcessManager.checkMargin(user,goods)){
           //判断是否缴纳保证金
            return NONE;
        }
        auction.setGoods_id(goods_id);
        auction.setPrice(price);
        if(auctionProcessManager.joinAuction(user,goods,auction))
            return SUCCESS;
        return ERROR;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.seesion = map;
    }
}
