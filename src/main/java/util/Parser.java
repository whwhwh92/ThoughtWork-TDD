package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import info.Cart;
import info.Goods;
import info.Offer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by Sora on 2016/7/8.
 */
public class Parser {

    public static Reader createUtf8Reader(InputStream in) {
        return new InputStreamReader(in, Charset.forName("UTF-8"));
    }

    public static HashMap<String, Goods> readGoodsFromJsonStream(InputStream in) {
        HashMap<String, Goods> goodsMap = new HashMap<>();

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();

        JsonArray jsonGoodsArray = jsonParser.parse(
                Parser.createUtf8Reader(in))
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
                Parser.createUtf8Reader(in))
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

    public static Cart readCartFromJsonStream(InputStream in) {
        Cart cart = new Cart();

        JsonParser jsonParser =  new JsonParser();

        JsonArray jsonBarcodeArray = jsonParser.parse(
                Parser.createUtf8Reader(in))
                .getAsJsonArray();

        for (int i = 0; i < jsonBarcodeArray.size(); ++i) {
            String item = jsonBarcodeArray.get(i).getAsString();

            String barcode;
            int count = 0;

            int pos = item.indexOf('-');
            if (pos > 0) {
                barcode = item.substring(0, pos);
                count = Integer.valueOf(item.substring(pos + 1));
            } else {
                barcode = item;
                count = 1;
            }

            cart.addItem(barcode, count);
        }

        return cart;
    }
}
