package Domain.Functionalities;

import Domain.Objects.Shooter;
import Domain.TransformStrategy.BlendBreak;
import Domain.TransformStrategy.BlendBreakStrategy;
import Domain.TransformStrategy.BlendBreakStrategyFactory;
import Domain.Useful.FinalValues;


import java.util.HashMap;

public class Blender {
    //Blender class is created for blend functionality. It is a singleton and created with Pure Fabrication pattern.
    private HashMap<String, HashMap<String, Integer>> blendRules = new HashMap<String, HashMap<String, Integer>>();
    public Blender(){
        HashMap<String, Integer> alphaMap = new HashMap<String, Integer>();
        alphaMap.put(FinalValues.BETA,2);
        alphaMap.put(FinalValues.GAMMA,3);
        alphaMap.put(FinalValues.SIGMA,4);
        blendRules.put(FinalValues.ALPHA, alphaMap);
        HashMap<String, Integer> betaMap = new HashMap<String, Integer>();
        betaMap.put(FinalValues.GAMMA, 2);
        betaMap.put(FinalValues.SIGMA, 3);
        blendRules.put(FinalValues.BETA, betaMap);
        HashMap<String, Integer> gammaMap = new HashMap<String, Integer>();
        gammaMap.put(FinalValues.SIGMA, 2);
        blendRules.put(FinalValues.GAMMA, gammaMap);
    }

    // Strategy Method

    public void Blend(String fromType, String toType){
        BlendBreakStrategyFactory blendBreakStrategyFactory=BlendBreakStrategyFactory.getInstance();
        BlendBreakStrategy blendBreakStrategy=blendBreakStrategyFactory.getStrategy(fromType,toType);
        BlendBreak blendBreak=new BlendBreak(blendBreakStrategy);
        boolean isBlended=blendBreak.executeBlend(blendRules.get("Atom"));
        if(isBlended){

        }else {

        }
    }

    public void Break(String fromType, String toType){
        BlendBreakStrategyFactory blendBreakStrategyFactory=BlendBreakStrategyFactory.getInstance();
        BlendBreakStrategy blendBreakStrategy=blendBreakStrategyFactory.getStrategy(toType,fromType);
        BlendBreak blendBreak=new BlendBreak(blendBreakStrategy);
        boolean isBroke=blendBreak.executeBreak(blendRules.get("Atom"));
        if(isBroke){

        }else {

        }
    }

    // Normal Method

    public void blend(String fromType, String toType){
        BlendBreakStrategyFactory blendBreakStrategyFactory=BlendBreakStrategyFactory.getInstance();
        BlendBreakStrategy blendBreakStrategy=blendBreakStrategyFactory.getStrategy(fromType,toType);
        BlendBreak blendBreak=new BlendBreak(blendBreakStrategy);
        blendBreak.executeBlend(blendRules.get("Atom"));

        if(blendRules.get(fromType) != null && blendRules.get(fromType).get(toType)!= null){
            int use = blendRules.get(fromType).get(toType);
            HashMap<String, Integer> shooterMap = Shooter.getInstance().getNumOfAtoms();
            if (shooterMap.get(fromType)>=use) {
                shooterMap.replace(fromType, shooterMap.get(fromType) - use);
                shooterMap.replace(toType, shooterMap.get(toType) + 1);
                Shooter.getInstance().setNumOfAtoms(shooterMap);
            }
        }
    }
    public void breakAtom(String fromType, String toType){
        BlendBreakStrategyFactory blendBreakStrategyFactory=BlendBreakStrategyFactory.getInstance();
        BlendBreakStrategy blendBreakStrategy=blendBreakStrategyFactory.getStrategy(fromType,toType);
        BlendBreak blendBreak=new BlendBreak(blendBreakStrategy);
        blendBreak.executeBreak(blendRules.get("Atom"));

        if(blendRules.get(toType) != null && blendRules.get(toType).get(fromType)!= null){
            int add = blendRules.get(toType).get(fromType);
            HashMap<String, Integer> shooterMap = Shooter.getInstance().getNumOfAtoms();
            if (shooterMap.get(fromType)>=1) {
                shooterMap.replace(toType, shooterMap.get(toType) + add);
                shooterMap.replace(fromType, shooterMap.get(fromType) - 1);
                Shooter.getInstance().setNumOfAtoms(shooterMap);
            }
        }
    }
}
