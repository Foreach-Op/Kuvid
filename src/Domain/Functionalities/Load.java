package Domain.Functionalities;

import Domain.Statistics.GameData;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Load {
    private String fileName="";

    public Load(String fileName){
        this.fileName=fileName;
    }

    public GameData LoadTheGame(){
        GameData data=null;
        try(FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream read = new ObjectInputStream(file)){
            data=(GameData) read.readObject();
            data.setLoaded(true); //sets the gameData is loaded
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
