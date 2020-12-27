package Domain.UserFunctionalities;

import org.json.simple.JSONObject;

public interface SaveLoadAdapter {

    JSONObject download(String filename) throws Exception;
    boolean upload(JSONObject json) throws Exception;
}
