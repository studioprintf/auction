package action.seller;

import action.BaseAction;
import org.apache.struts2.interceptor.RequestAware;
import pojo.Goods;
import pojo.Goodsinfo;
import service.GoodsManagerImpl;

import java.util.Map;

/**
 * Created by lucifer on 17-4-10.
 * 卖家更新商品信息
 */
public class SellerUpdateInfoAction extends BaseAction {
    private int goods_id;
    private String goods_title;
    private String goods_describe;
    private String goods_image1;
    private String goods_image2;
    private String goods_image3;
    private String goods_image4;
    private String goods_image5;

    private GoodsManagerImpl goodsManager;

    public void setGoodsManager(GoodsManagerImpl goodsManager) {
        this.goodsManager = goodsManager;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_describe() {
        return goods_describe;
    }

    public void setGoods_describe(String goods_describe) {
        this.goods_describe = goods_describe;
    }

    public String getGoods_image1() {
        return goods_image1;
    }

    public void setGoods_image1(String goods_image1) {
        this.goods_image1 = goods_image1;
    }

    public String getGoods_image2() {
        return goods_image2;
    }

    public void setGoods_image2(String goods_image2) {
        this.goods_image2 = goods_image2;
    }

    public String getGoods_image3() {
        return goods_image3;
    }

    public void setGoods_image3(String goods_image3) {
        this.goods_image3 = goods_image3;
    }

    public String getGoods_image4() {
        return goods_image4;
    }

    public void setGoods_image4(String goods_image4) {
        this.goods_image4 = goods_image4;
    }

    public String getGoods_image5() {
        return goods_image5;
    }

    public void setGoods_image5(String goods_image5) {
        this.goods_image5 = goods_image5;
    }

    @Override
    public String execute() throws Exception {
        Goods goods = new Goods();
        goods.setGoods_id(goods_id);
        Goodsinfo goodsinfo = goodsManager.getGoodsInfo(goods);  //根据商品id取出商品信息
        if(!goods.getState().equals("等待")&&!(Integer.parseInt(session.get("USER_ID").toString())==goods.getCreate_user())){  //判断商品状态是否为“等待”，只有处于等待状态的商品可以进行修改
            return ERROR;
        }
        goodsinfo.setGoods_title(getGoods_title());
        goodsinfo.setGoods_describe(getGoods_describe());
        goodsinfo.setGoods_image1(goods_image1);
        if(getGoods_image2()!=null) {
            goodsinfo.setGoods_image1(getGoods_image2());
            if(getGoods_image3()!=null){
                goodsinfo.setGoods_image2(getGoods_image3());
                if(getGoods_image4()!=null){
                    goodsinfo.setGoods_image4(getGoods_image4());
                    if(getGoods_image5()!=null){
                        goodsinfo.setGoods_image5(getGoods_image5());
                    }
                }
            }
        }
        if(goodsManager.updateGoodsInfo(goodsinfo))
            return SUCCESS;
        return ERROR;
    }
}
