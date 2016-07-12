package module;

import info.Cart;
import info.Goods;
import info.Offer;
import util.Parser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Created by Sora on 2016/7/12.
 */
public class CashModule {

    private static final String JSON_GOODS = "goods.json";
    private static final String JSON_OFFER = "offer.json";
    private static final String JSON_CART = "cart.json";

    HashMap<String, Goods> goodsMap = null;
    Offer offer = null;

    POS pos = new POS();

    private static Reader getJsonReader(String file) {
        InputStream in = CashModule.class.getClassLoader()
                .getResourceAsStream(file);
        return new InputStreamReader(in,
                Charset.forName("UTF-8"));
    }

    private void readGoodsAndOffer() {
        goodsMap = Parser.readGoodsFromJsonReader(
                getJsonReader(JSON_GOODS));
        offer = Parser.readOfferFromJsonReader(
                getJsonReader(JSON_OFFER));
    }

    public void init() {
        readGoodsAndOffer();
        pos.setOffer(offer);
    }

    public Cart readGoodsCart(String file) {
        return Parser.readCartFromJsonReader(
                getJsonReader(file), goodsMap);
    }

    public Receipt getReceipt(Cart cart) {
        return pos.getReceipt(cart);
    }

    public static void main(String[] args) {
        CashModule module = new CashModule();
        module.init();

        Cart cart = module.readGoodsCart(JSON_CART);
        Receipt receipt = module.getReceipt(cart);

        System.out.println(receipt.getText());
    }
}
