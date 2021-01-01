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
            Save save=new Save(username);
            JSONObject json=save.SaveTheGame();
            adapter.upload(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Load(String filename){
        try {
            //bundan sonra json ayrıştırma yeri çağırılıp yapılabilir.
            Load load=new Load();
            JSONObject json=adapter.download(filename);
            load.LoadTheGame(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
