package util;

import info.Goods;
import info.Offer;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sora on 2016/7/11.
 */
public class TestDataBuilder {

    public static HashMap<String, Goods> getGoodsMap() {
        HashMap<String, Goods> goodsMap = new HashMap<>();

        Goods goods = new Goods();
        goods.setBarcode("ITEM000001");
        goods.setName("可口可乐");
        goods.setCategory("食品");
        goods.setSubCategory("饮料");
        goods.setUnit("瓶");
        goods.setPrice(3.00f);
        goodsMap.put(goods.getBarcode(), goods);

        goods = new Goods();
        goods.setBarcode("ITEM000003");
        goods.setName("苹果");
        goods.setCategory("食品");
        goods.setSubCategory("水果");
        goods.setUnit("斤");
        goods.setPrice(5.50f);
        goodsMap.put(goods.getBarcode(), goods);

        goods = new Goods();
        goods.setBarcode("ITEM000005");
        goods.setName("羽毛球");
        goods.setCategory("体育用品");
        goods.setSubCategory("球类");
        goods.setUnit("个");
        goods.setPrice(1.00f);
        goodsMap.put(goods.getBarcode(), goods);

        return goodsMap;
    }

    public static Goods getGoods() {
        return getGoodsMap().get("ITEM000003");
    }

    public static Goods getOfferGoods() {
        return getGoodsMap().get("ITEM000001");
    }

    public static Goods getNonOfferGoods() {
        return getGoodsMap().get("ITEM000003");
    }

    public static Offer getOffer() {
        Offer offer = new Offer();
        offer.add("ITEM000001");
        offer.add("ITEM000005");
        return offer;
    }
}
