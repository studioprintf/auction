package action.auction;

import com.opensymphony.xwork2.ActionSupport;
import pojo.Auction;
import service.AuctionProcessManagerImpl;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dymond on 2017/4/13.
 */
@Transactional
public class GetRightShowBidsAction extends ActionSupport{
        private static final long serialVersionUID = 1L;
        private AuctionProcessManagerImpl auctionProcessManager;


        private String goods_id;
        private Map<String, Object> dataMap;


    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public AuctionProcessManagerImpl getAuctionProcessManager() {
            return auctionProcessManager;
        }

        public void setAuctionProcessManager(AuctionProcessManagerImpl auctionProcessManager) {
            this.auctionProcessManager = auctionProcessManager;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String json() {
            dataMap = new HashMap<String, Object>();
            List<Auction> auctionList = null;

            List<?> list = auctionProcessManager.getBidsList(goods_id, 1, 5);
            if (list.isEmpty()) {
                dataMap.put("viewPrice", "");
                dataMap.put("list", "");
            } else {
                auctionList = (List<Auction>) list;
                String viewPrice = String.valueOf(auctionList.get(0).getPrice());
                dataMap.put("viewPrice", viewPrice);
                dataMap.put("list", auctionList);

            }
            return SUCCESS;


        }
}
