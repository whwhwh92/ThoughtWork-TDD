import com.google.gson.JsonObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonFileReaderTest {
    @Test
    public void should_return_json_object_read_from_file_when_specified_one_file_to_read() throws Exception {
        JsonFileReader jsonFileReader = new JsonFileReader();

        JsonObject jsonObject = jsonFileReader.read("promotion-products-list.json");
        JsonObject firstProductOnPromotion = jsonObject.get("promotion").getAsJsonObject().get("buy_three_free_one").getAsJsonArray().get(0).getAsJsonObject();

        assertThat(firstProductOnPromotion.get("barcode").getAsString(), is("ITEM000000"));
        assertThat(firstProductOnPromotion.get("name").getAsString(), is("cokacola"));
        assertThat(firstProductOnPromotion.get("price").getAsDouble(), is(3.00));
    }
}
