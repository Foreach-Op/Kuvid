package Domain.UserFunctionalities;

import org.json.simple.JSONObject;

public class SaveLoadHandler {

    //burası çağırılarak yapılabilir.
    private SaveLoadAdapter adapter;

    public SaveLoadHandler(){
        LocalMongoFactory fac=new LocalMongoFactory();
        adapter=fac.getAdapter();
    }



    public void Save(String username){ //username-playername-filename is same

        try {
            //json yaratılacak
            //filename json içine yazılacak
            JSONObject json=new JSONObject();
            adapter.upload(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Load(String filename){
        try {
            //bundan sonra json ayrıştırma yeri çağırılıp yapılabilir.
            JSONObject json=adapter.download(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
