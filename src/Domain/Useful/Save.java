package Domain.Useful;

import Domain.Singletons.GameConfiguration;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Save {
    private String fileName="";

    public Save(String fileName){
        this.fileName=fileName;
    }

    public void SaveTheGame(){
        try(FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream write = new ObjectOutputStream(file)){

            GameConfiguration gameConfiguration = GameConfiguration.getInstance();
            GameData data=gameConfiguration.getData();

            write.writeObject(data);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
