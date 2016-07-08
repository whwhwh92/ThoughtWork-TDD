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

    private static InputStream getStream(String res) {
        return Parser.class.getClassLoader()
                .getResourceAsStream(res);
    }

    @Test
    public void should_parse_right_goods_info_from_json_file()
            throws Exception {
        HashMap<String, Goods> goodsMap = Parser.readFromJsonStream(
                ParserTest.getStream(JSON_GOODS));
        assertEquals(6, goodsMap.size());

        Goods goods = goodsMap.get("ITEM000003");
        assertNotNull(goods);

        assertEquals("ITEM000003", goods.getBarcode());
        assertEquals("ƻ��", goods.getName());
        assertEquals("ʳƷ", goods.getCategory());
        assertEquals("ˮ��", goods.getSubCategory());
        assertEquals("��", goods.getUnit());
        assertEquals(5.50f, goods.getPrice(), 0.001f);
    }

}