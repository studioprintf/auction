package action.goods;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import pojo.Goods;
import pojo.Goodsinfo;
import service.GoodsManagerImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dymond on 2017/4/17.
 */
public class ListGoodsAction extends ActionSupport implements RequestAware {
    private Map<String, Object> request;
    private GoodsManagerImpl goodsManager;

    private int totalCount;
    private int pageNum;

    private List<Goods> goodsList;
    private List<Goodsinfo> goodsInfoList;

    public Map<String, Object> getRequest() {
        return request;
    }

    public GoodsManagerImpl getGoodsManager() {
        return goodsManager;
    }

    public void setGoodsManager(GoodsManagerImpl goodsManager) {
        this.goodsManager = goodsManager;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Goodsinfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<Goodsinfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    @Override
    public String execute() throws Exception {
        int numPerPage = 20;
        int onsaleNum = goodsManager.onSaleNum();
        HashMap<String,List> map = goodsManager.getGoodsList(pageNum,numPerPage);
        goodsList = map.get("Goods");
        goodsInfoList = map.get("GoodsInfo");
        request.put("totalCount",onsaleNum);


        return SUCCESS;
    }
}
