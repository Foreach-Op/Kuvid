package Domain.Useful;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Load {
    private String fileName="";

    public Load(String fileName){
        this.fileName=fileName;
    }

    public ConfigureData LoadTheGame(){
        ConfigureData data=null;
        try(FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream read = new ObjectInputStream(file)){
            data=(ConfigureData) read.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
