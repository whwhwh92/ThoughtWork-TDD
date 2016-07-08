package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import info.Goods;
import info.Offer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by Sora on 2016/7/8.
 */
public class Parser {

    public static HashMap<String, Goods> readGoodsFromJsonStream(InputStream in) {
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

    public static Offer readOfferFromJsonStream(InputStream in) {
        Offer offer = new Offer();

        JsonParser jsonParser = new JsonParser();

        JsonObject jsonOffer = jsonParser.parse(
                new InputStreamReader(in, Charset.forName("UTF-8")))
                .getAsJsonArray().get(0)
                .getAsJsonObject();

        if (jsonOffer.get("type").getAsString()
                .equals("BUY_THREE_GET_ONE_FREE")) {
            JsonArray jsonBarcodes = jsonOffer.get("barcodes")
                    .getAsJsonArray();
            for (int i = 0; i < jsonBarcodes.size(); ++i) {
                String barcode = jsonBarcodes.get(i).getAsString();
                offer.add(barcode);
            }
        }

        return offer;
    }
}
