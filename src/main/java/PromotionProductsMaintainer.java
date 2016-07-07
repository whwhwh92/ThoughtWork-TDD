import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import domain.Product;
import domain.PromotionProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PromotionProductsMaintainer {

    private List<PromotionProduct> promotionProductList = new ArrayList<>();

    // Seems this is interface provided to test code only for now
    public PromotionProductsMaintainer(List<PromotionProduct> promotionProductList) {
        this.promotionProductList = promotionProductList;
    }

    public PromotionProductsMaintainer() throws IOException {
        readListOfPromotionProductFromFile("promotion-products-list.json");
    }

    private void readListOfPromotionProductFromFile(String filename) throws IOException {
        JsonObject jsonFileContent = new JsonFileReader().read(filename);
        JsonArray productsOnPromotion = jsonFileContent.get("promotion").getAsJsonObject().get("buy_three_free_one").getAsJsonArray();

        for (JsonElement product : productsOnPromotion) {
            PromotionProduct promotionProduct = new PromotionProduct();
            JsonObject json = product.getAsJsonObject();

            promotionProduct.setBarcode(json.get("barcode").getAsString());
            promotionProduct.setProductName(json.get("name").getAsString());
            promotionProduct.setUnit(json.get("unit").getAsString());
            promotionProduct.setCategory(json.get("category").getAsString());
            promotionProduct.setSubCategory(json.get("subCategory").getAsString());
            promotionProduct.setPrice(json.get("price").getAsString());

            this.promotionProductList.add(promotionProduct);
        }

    }

    public boolean contains(Product product) {
        for (PromotionProduct promotionProduct : this.promotionProductList) {
            if (promotionProduct.getProductName().equals(product.getName())) {
                return true;
            }
        }
        return false ;
    }
}
