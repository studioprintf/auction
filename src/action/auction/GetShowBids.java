package action.auction;

import com.opensymphony.xwork2.ActionSupport;
import pojo.Auction;
import pojo.Goods;
import service.AuctionProcessManagerImpl;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dymond on 2017/4/12.
 */
@Transactional
public class GetShowBids extends ActionSupport {
        private static final long serialVersionUID = 1L;

    private String goods_id;
    private String numPerPage;
    private String pageNum;
    private Map<String,Object> dataMap;

    private Auction auction;
    private Goods goods;

    private AuctionProcessManagerImpl auctionProcessManager;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(String numPerPage) {
        this.numPerPage = numPerPage;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }


    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
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

    public String json() {
        String maxPrice;
        List<Auction> auctionList = null;
        goods = new Goods();
        dataMap = new HashMap<String, Object>();
        int index = Integer.parseInt(pageNum);

        goods.setGoods_id(Integer.parseInt(getGoods_id()));
        int maxPage = auctionProcessManager.getBidsNum(goods, numPerPage);
        if (index > maxPage) {
            return ERROR;
        }
        List<?> list = auctionProcessManager.getBidsList(goods_id, index, Integer.parseInt(numPerPage));//找到当前页数的auction

        if (list.isEmpty()) {
            dataMap.put("viewPrice", "");//max Price
            dataMap.put("pageNum", 1);
            dataMap.put("PageCount", 1);
            dataMap.put("list", "");
        } else {
            auctionList = (List<Auction>) list;
            maxPrice = String.valueOf(auctionList.get(0).getPrice());
            dataMap.put("viewPrice", maxPrice);//max Price
            dataMap.put("pageNum", index);
            dataMap.put("PageCount", maxPage);
            dataMap.put("list", auctionList);
        }
        return SUCCESS;
    }

}
