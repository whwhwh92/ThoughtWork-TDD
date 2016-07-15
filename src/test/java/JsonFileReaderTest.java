import com.google.gson.JsonObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class JsonFileReaderTest {
    @Test
    public void should_return_json_object_read_from_total_commodity_information_json() throws Exception{

        JsonTotalCommodityInformationFileReader   TotalCommodityInformationJsonFile = new JsonTotalCommodityInformationFileReader ();
        JsonObject jsonObject = JsonTotalCommodityInformationFileReader.read("total-commodity-information.json");
        JsonObject firstProductOfTotal = jsonObject.get("commodity").getAsJsonObject().get("total_commodity_information").getAsJsonArray().get(0).getAsJsonObject();
        assertThat(firstProductOfTotal.get("barcode").getAsString(),is("ITEM000000"));
        assertThat(firstProductOfTotal.get("name").getAsString(),is("cokacola"));
        assertThat(firstProductOfTotal.get("unit").getAsString(),is("瓶"));
        assertThat(firstProductOfTotal.get("category").getAsString(),is("食品"));
        assertThat(firstProductOfTotal.get("subCategory").getAsString(),is("食品"));
        assertThat(firstProductOfTotal.get("price").getAsDouble(),is(3.00));
        JsonObject secondProductOfTotal = jsonObject.get("commodity").getAsJsonObject().get("total_commodity_information").getAsJsonArray().get(1).getAsJsonObject();
        assertThat(secondProductOfTotal.get("barcode").getAsString(),is("ITEM000001"));
        assertThat(secondProductOfTotal.get("name").getAsString(),is("apple"));
        assertThat(secondProductOfTotal.get("unit").getAsString(),is("个"));
        assertThat(secondProductOfTotal.get("category").getAsString(),is("食品"));
        assertThat(secondProductOfTotal.get("subCategory").getAsString(),is("水果"));
        assertThat(secondProductOfTotal.get("price").getAsDouble(),is(2.00));
        JsonObject thirdProductOfTotal = jsonObject.get("commodity").getAsJsonObject().get("total_commodity_information").getAsJsonArray().get(2).getAsJsonObject();
        assertThat(thirdProductOfTotal.get("barcode").getAsString(),is("ITEM000002"));
        assertThat(thirdProductOfTotal.get("name").getAsString(),is("pear"));
        assertThat(thirdProductOfTotal.get("unit").getAsString(),is("个"));
        assertThat(thirdProductOfTotal.get("category").getAsString(),is("食品"));
        assertThat(thirdProductOfTotal.get("subCategory").getAsString(),is("水果"));
        assertThat(thirdProductOfTotal.get("price").getAsDouble(),is(2.00));
        JsonObject fourthProductOfTotal = jsonObject.get("commodity").getAsJsonObject().get("total_commodity_information").getAsJsonArray().get(3).getAsJsonObject();
        assertThat(fourthProductOfTotal.get("barcode").getAsString(),is("ITEM000003"));
        assertThat(fourthProductOfTotal.get("name").getAsString(),is("tomato"));
        assertThat(fourthProductOfTotal.get("unit").getAsString(),is("斤"));
        assertThat(fourthProductOfTotal.get("category").getAsString(),is("食品"));
        assertThat(fourthProductOfTotal.get("subCategory").getAsString(),is("水果"));
        assertThat(fourthProductOfTotal.get("price").getAsDouble(),is(3.00));
        JsonObject fifthProductOfTotal = jsonObject.get("commodity").getAsJsonObject().get("total_commodity_information").getAsJsonArray().get(3).getAsJsonObject();
        assertThat(fifthProductOfTotal.get("barcode").getAsString(),is("ITEM000004"));
        assertThat(fifthProductOfTotal.get("name").getAsString(),is("watermelon"));
        assertThat(fifthProductOfTotal.get("unit").getAsString(),is("斤"));
        assertThat(fifthProductOfTotal.get("category").getAsString(),is("食品"));
        assertThat(fifthProductOfTotal.get("subCategory").getAsString(),is("水果"));
        assertThat(fifthProductOfTotal.get("price").getAsDouble(),is(5.00));
    }
    @Test
    public void should_return_json_object_read_from_promotion_commodity_list_json() throws Exception{
        JsonPromotionCommodityListFileReader   PromotionCommodityListJsonFile = new JsonPromotionCommodityListFileReader ();
        JsonObject jsonObject = JsonPromotionCommodityListFileReader.read("promotion-commodity-list.json");
        JsonObject ProductOfPromotion = jsonObject.get("promotion").getAsJsonObject();
        assertThat(ProductOfPromotion.get("type").getAsString(),is("buy_three_get_one_free"));
        JsonObject firstProductOfPromotion = ProductOfPromotion.get("barcode").getAsJsonArray().get(0).getAsJsonObject();
        assertThat(firstProductOfPromotion.get("ITEM000000").getAsString(),is("ITEM000000"));
        JsonObject secondProductOfPromotion = ProductOfPromotion.get("barcode").getAsJsonArray().get(1).getAsJsonObject();
        assertThat(secondProductOfPromotion.get("ITEM000001").getAsString(),is("ITEM000001"));
        JsonObject thirdProductOfPromotion = ProductOfPromotion.get("barcode").getAsJsonArray().get(2).getAsJsonObject();
        assertThat(thirdProductOfPromotion.get("ITEM000002").getAsString(),is("ITEM000002"));

    }
    @Test
    public  void  should_return_json_object_read_from_buy_commodity_list_json()throws Exception {
        JsonBuyCommodityListFileReader   BuyCommodityListJsonFile = new JsonBuyCommodityListFileReader ();
        JsonObject jsonObject = JsonBuyCommodityListFileReader.read("buy-commodity-list.json");
        JsonObject firstProductOfPromotion = jsonObject.getAsJsonArray().get(0).getAsJsonObject();
        assertThat(firstProductOfPromotion.get("ITEM000001").getAsString(),is("ITEM000001"));
        JsonObject secondProductOfPromotion = jsonObject.getAsJsonArray().get(1).getAsJsonObject();
        assertThat(secondProductOfPromotion.get("ITEM000001").getAsString(),is("ITEM000001"));
        JsonObject thirdProductOfPromotion = jsonObject.getAsJsonArray().get(2).getAsJsonObject();
        assertThat(thirdProductOfPromotion.get("ITEM000003-2").getAsString(),is("ITEM000003-2"));
        JsonObject fourthProductOfPromotion = jsonObject.getAsJsonArray().get(3).getAsJsonObject();
        assertThat(fourthProductOfPromotion.get("ITEM000004").getAsString(),is("ITEM000004"));
        JsonObject fifthProductOfPromotion = jsonObject.getAsJsonArray().get(4).getAsJsonObject();
        assertThat(fifthProductOfPromotion.get("ITEM000004").getAsString(),is("ITEM000004"));
        JsonObject sixthProductOfPromotion = jsonObject.getAsJsonArray().get(5).getAsJsonObject();
        assertThat(sixthProductOfPromotion.get("ITEM000004").getAsString(),is("ITEM000004"));
    }
}
