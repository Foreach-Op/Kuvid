package Domain.UserFunctionalities;

import Domain.Statistics.GameData;
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

    public GameData Load(String filename){
        GameData gameData=null;
        try {
            //bundan sonra json ayrıştırma yeri çağırılıp yapılabilir.
            Load load=new Load();
            JSONObject json=adapter.download(filename);
            gameData=load.LoadTheGame(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameData;
    }





}
