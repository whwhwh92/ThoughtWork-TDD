package util;

import info.Goods;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Sora on 2016/7/8.
 */
public class ParserTest {

    private static final String JSON_GOODS = "goods.json";
    private static final String JSON_OFFER = "offer.json";

    private static InputStream getStream(String res) {
        return Parser.class.getClassLoader()
                .getResourceAsStream(res);
    }

    @Test
    public void should_parse_right_goods_info_from_json_file()
            throws Exception {
        HashMap<String, Goods> goodsMap = Parser
                .readGoodsFromJsonStream(
                        ParserTest.getStream(JSON_GOODS));
        assertEquals(6, goodsMap.size());

        Goods goods = goodsMap.get("ITEM000003");
        assertNotNull(goods);

        assertEquals("ITEM000003", goods.getBarcode());
        assertEquals("苹果", goods.getName());
        assertEquals("食品", goods.getCategory());
        assertEquals("水果", goods.getSubCategory());
        assertEquals("斤", goods.getUnit());
        assertEquals(5.50f, goods.getPrice(), 0.001f);
    }

    private static Goods genOfferGoods() {
        Goods goods = new Goods();
        goods.setBarcode("ITEM000001");
        goods.setName("可口可乐");
        goods.setCategory("食品");
        goods.setSubCategory("饮料");
        goods.setUnit("瓶");
        goods.setPrice(3.00f);
        return goods;
    }

    private static Goods genNonOfferGoods() {
        Goods goods = new Goods();
        goods.setBarcode("ITEM000003");
        goods.setName("苹果");
        goods.setCategory("食品");
        goods.setSubCategory("水果");
        goods.setUnit("斤");
        goods.setPrice(5.50f);
    }

    @Test
    public void should_parse_right_offer_info_from_json_file()
            throws Exception {
        Offer offer = Parser.readOfferFromJsonStream(
                ParserTest.getStream(JSON_OFFER));

        assertTrue(offer.check(ParserTest.genOfferGoods()));
        assertFalse(offer.check(ParserTest.genNonOfferGoods()));
    }
}