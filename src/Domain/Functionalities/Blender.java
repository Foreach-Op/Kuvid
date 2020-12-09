package Domain.Functionalities;

import Domain.Statistics.GameConfiguration;
import Domain.TransformStrategy.BlendBreak;
import Domain.TransformStrategy.TransformStrategy;
import Domain.TransformStrategy.TransformStrategyFactory;
import Domain.Useful.FinalValues;
import java.util.HashMap;

public class Blender {

    private final HashMap<String, HashMap<String, Integer>> ammo;

    public Blender(){
        ammo = GameConfiguration.getInstance().getData().getAmmunition();
    }

    public void Transform(String fromType, String toType){
        TransformStrategyFactory transformStrategyFactory = TransformStrategyFactory.getInstance();
        TransformStrategy transformStrategy = transformStrategyFactory.getStrategy(fromType,toType);
        BlendBreak blendBreak=new BlendBreak(transformStrategy);
        boolean isTransformed=blendBreak.executeTransform(ammo.get(FinalValues.ATOM));
        if(isTransformed){
        GameConfiguration.getInstance().setAmmunition(ammo);
        }else {

        }
    }
}
