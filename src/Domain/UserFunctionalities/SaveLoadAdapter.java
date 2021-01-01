package Domain.UserFunctionalities;

import org.json.simple.JSONObject;

import java.util.List;

public interface SaveLoadAdapter {

    JSONObject download(String filename) throws Exception;
    boolean upload(JSONObject json) throws Exception;
    List<String> savedFiles() throws Exception;
}
