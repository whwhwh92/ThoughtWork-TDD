package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import info.Goods;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by Sora on 2016/7/8.
 */
public class Parser {

    public static HashMap<String, Goods> readFromJsonStream(InputStream in) {
        HashMap<String, Goods> goodsMap = new HashMap<>();

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();

        JsonArray jsonGoodsArray = jsonParser.parse(
                new InputStreamReader(in, Charset.forName("UTF-8")))
                .getAsJsonArray();
        for (int i = 0; i < jsonGoodsArray.size(); ++i) {
            JsonObject jsonGoods = jsonGoodsArray.get(i)
                    .getAsJsonObject();

            Goods goods = gson.fromJson(jsonGoods, Goods.class);
            goodsMap.put(goods.getBarcode(), goods);
        }

        return goodsMap;
    }

}
