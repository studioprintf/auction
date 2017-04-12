package action.goods;

import com.opensymphony.xwork2.ActionSupport;
import pojo.Auction;
import service.AuctionProcessManagerImpl;

import java.util.Map;

/**
 * Created by Dymond on 2017/4/12.
 */
public class GetShowBids extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private String id;
    private String numPerPage;
    private String pageNum;
    private Map<String,Object> dataMap;

    private Auction auction;

    private AuctionProcessManagerImpl auctionProcessManager;



}
