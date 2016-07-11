package util;

import info.Cart;
import info.Goods;
import info.Offer;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Sora on 2016/7/8.
 */
public class ParserTest {

    private static final String JSON_GOODS = "goods.json";
    private static final String JSON_OFFER = "offer.json";
    private static final String JSON_CART = "cart.json";

    private String getResPath(String res) {
        URL url = getClass().getClassLoader().getResource(res);
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getPath();
    }

    @Test
    public void should_parse_right_goods_info_from_json_file()
            throws Exception {
        HashMap<String, Goods> goodsMap = Parser
                .readGoodsFromJsonFile(getResPath(JSON_GOODS));
        assertEquals(6, goodsMap.size());

        Goods testGoods = TestDataBuilder.getGoods();
        Goods goods = goodsMap.get(testGoods.getBarcode());

        assertEquals(testGoods.getBarcode(), goods.getBarcode());
        assertEquals(testGoods.getName(), goods.getName());
        assertEquals(testGoods.getCategory(), goods.getCategory());
        assertEquals(testGoods.getSubCategory(), goods.getSubCategory());
        assertEquals(testGoods.getUnit(), goods.getUnit());
        assertEquals(testGoods.getPrice(), goods.getPrice(), 0.001f);
    }

    @Test
    public void should_parse_right_offer_info_from_json_file()
            throws Exception {
        Offer offer = Parser.readOfferFromJsonFile(
                getResPath(JSON_OFFER));

        assertTrue(offer.check(TestDataBuilder.getOfferGoods()));
        assertFalse(offer.check(TestDataBuilder.getNonOfferGoods()));
    }

    @Test
    public void should_parse_cart_with_right_barcode_from_json_file()
            throws Exception {
        Cart cart = Parser.readCartFromJsonFile(
                getResPath(JSON_CART));

        assertEquals(3, cart.getItemCount());
        assertEquals(3, cart.getQuantity("ITEM000001"));
        assertEquals(2, cart.getQuantity("ITEM000003"));
        assertEquals(5, cart.getQuantity("ITEM000005"));
    }
}