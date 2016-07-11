package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import info.Cart;
import info.Goods;
import info.Offer;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by Sora on 2016/7/8.
 */
public class Parser {

    public static Reader createFileReader(String jsonfile)
            throws FileNotFoundException {
        InputStream in = new FileInputStream(jsonfile);
        Reader reader = new InputStreamReader(in,
                Charset.forName("UTF-8"));
        return reader;
    }

    public static HashMap<String, Goods>
            readGoodsFromJsonReader(Reader reader) {
        HashMap<String, Goods> goodsMap = new HashMap<>();

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();

        JsonArray jsonGoodsArray = jsonParser
                .parse(reader).getAsJsonArray();

        for (int i = 0; i < jsonGoodsArray.size(); ++i) {
            JsonObject jsonGoods = jsonGoodsArray.get(i)
                    .getAsJsonObject();

            Goods goods = gson.fromJson(jsonGoods, Goods.class);
            goodsMap.put(goods.getBarcode(), goods);
        }

        return goodsMap;
    }

    public static Offer readOfferFromJsonReader(Reader reader) {
        Offer offer = new Offer();

        JsonParser jsonParser = new JsonParser();

        JsonObject jsonOffer = jsonParser
                .parse(reader).getAsJsonArray()
                .get(0).getAsJsonObject();

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

    public static Cart readCartFromJsonReader(Reader reader) {
        Cart cart = new Cart();

        JsonParser jsonParser =  new JsonParser();

        JsonArray jsonBarcodeArray = jsonParser
                .parse(reader).getAsJsonArray();

        for (int i = 0; i < jsonBarcodeArray.size(); ++i) {
            String item = jsonBarcodeArray.get(i).getAsString();

            int pos = item.indexOf('-');
            if (pos > 0) {
                cart.addItem(item.substring(0, pos),
                        Integer.valueOf(item.substring(pos + 1)));
            } else {
                cart.addItem(item, 1);
            }
        }

        return cart;
    }

    public static HashMap<String, Goods>
            readGoodsFromJsonFile(String path)
            throws FileNotFoundException {
        return readGoodsFromJsonReader(
                createFileReader(path));
    }

    public static Offer readOfferFromJsonFile(String path)
            throws FileNotFoundException {
        return readOfferFromJsonReader(
                createFileReader(path));
    }

    public static Cart readCartFromJsonFile(String path)
            throws FileNotFoundException {
        return readCartFromJsonReader(
                createFileReader(path));
    }
}
