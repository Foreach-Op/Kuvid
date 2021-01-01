package Domain.UserFunctionalities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Local implements SaveLoadAdapter {


    @Override
    public JSONObject download(String filename) throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("save_files/"+filename+".json");
        Object obj = jsonParser.parse(reader);
        JSONObject json = (JSONObject) obj;
        return json;
    }

    @Override
    public boolean upload(JSONObject json) throws Exception {
        FileWriter file = new FileWriter("save_files/"+json.get("username")+".json");
        file.write(json.toJSONString());
        file.flush();
        file.close();
        return true;
    }
}
