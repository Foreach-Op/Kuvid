package Domain.Functionalities;

import Domain.Statistics.GameConfiguration;
import Domain.TransformStrategy.BlendBreak;
import Domain.TransformStrategy.BlendBreakStrategy;
import Domain.TransformStrategy.BlendBreakStrategyFactory;
import Domain.Useful.FinalValues;
import java.util.HashMap;

public class Blender {

    private final HashMap<String, HashMap<String, Integer>> ammo;

    public Blender(){
        ammo = GameConfiguration.getInstance().getData().getAmmunition();
    }

    public void Blend(String fromType, String toType){
        BlendBreakStrategyFactory blendBreakStrategyFactory=BlendBreakStrategyFactory.getInstance();
        BlendBreakStrategy blendBreakStrategy=blendBreakStrategyFactory.getStrategy(fromType,toType);
        BlendBreak blendBreak=new BlendBreak(blendBreakStrategy);
        boolean isBlended=blendBreak.executeBlend(ammo.get(FinalValues.ATOM));
        if(isBlended){
        GameConfiguration.getInstance().setAmmunition(ammo);
        }else {

        }
    }

    public void Break(String fromType, String toType){
        BlendBreakStrategyFactory blendBreakStrategyFactory=BlendBreakStrategyFactory.getInstance();
        BlendBreakStrategy blendBreakStrategy=blendBreakStrategyFactory.getStrategy(toType,fromType);
        BlendBreak blendBreak=new BlendBreak(blendBreakStrategy);
        boolean isBroke=blendBreak.executeBreak(ammo.get(FinalValues.ATOM));
        if(isBroke){

        }else {

        }
    }
}
