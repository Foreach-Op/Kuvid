package Application.Modes;

import Domain.Singletons.GameConfiguration;
import Domain.Useful.ConfigureData;

import java.util.HashMap;

public class BuildMode {

    public void check(ConfigureData data,boolean isLoad){
        if(isLoad){
            GameConfiguration.getInstance().setData(data);
        }
        if(isValid(data)){
            GameConfiguration.getInstance().setData(data);
        }else {
            //Observer
        }
    }

    public boolean isValid(ConfigureData data){
        return true;
    }
}
