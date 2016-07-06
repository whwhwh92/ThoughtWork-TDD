import com.google.gson.JsonObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.notNull;

public class JsonFileReaderTest {
    @Test
    public void should_return_json_object_read_from_file_when_specified_one_file_to_read() throws Exception {
        JsonFileReader jsonFileReader = new JsonFileReader();

        JsonObject jsonObject = jsonFileReader.read("promotion-products-list.json").toJson();

        assertThat(jsonObject.get("promotion"), instanceOf(Object.class));
    }
}
