import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {

    private String fileContent = "";

    public JsonFileReader read(String jsonFileName) throws IOException {
        File jsonFile = new File(this.getClass().getClassLoader().getResource(jsonFileName).getFile());
        this.fileContent = FileUtils.readFileToString(jsonFile, "UTF-8");

        return this;
    }

    public JsonObject toJson() {
        System.out.println("fileContent: " + fileContent);
        return new JsonParser().parse(fileContent).getAsJsonObject();
    }
}
