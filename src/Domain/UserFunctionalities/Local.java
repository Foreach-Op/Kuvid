package Domain.UserFunctionalities;

import org.json.simple.JSONObject;

public class Local implements SaveLoadAdapter {

    @Override
    public JSONObject download(String filename) throws Exception {
        return null;
    }

    @Override
    public boolean upload(JSONObject json) throws Exception {
        return false;
    }
}
