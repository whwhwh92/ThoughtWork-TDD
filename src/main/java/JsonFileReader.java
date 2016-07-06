import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {

    public JsonObject read(String jsonFileName) throws IOException {
        String fileContent = getJsonFileContentAsString(jsonFileName);

        return new JsonParser().parse(fileContent).getAsJsonObject();
    }

    private String getJsonFileContentAsString(String jsonFileName) throws IOException {
        File jsonFile = new File(this.getClass().getClassLoader().getResource(jsonFileName).getFile());

        return FileUtils.readFileToString(jsonFile, "UTF-8");
    }

}
