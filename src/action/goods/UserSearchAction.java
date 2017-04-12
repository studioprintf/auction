package action.goods;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import service.GoodsManagerImpl;

import java.util.List;
import java.util.Map;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����4:31:17
 * @parameter
 * @return
 */
@Controller
public class UserSearchAction implements Action,RequestAware {
    private String searchKey;  //搜索关键词
    private int index;  //页数

    private Map<String, Object> request;
    private GoodsManagerImpl goodsManager;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public void setGoodsManager(GoodsManagerImpl goodsManager) {
        this.goodsManager = goodsManager;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        List<?> goodList = goodsManager.searchGoods(searchKey,index);  //根据页数和关键词搜索商品
        if(goodList.isEmpty()){
            return ERROR;
        }
        request.put("RESULTLIST",goodList);  //将商品放入"RESULTLIST"中
        request.put("RESULTNUM",index);  //将结果的总页数放在"RESULTNUM"中
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }
}
