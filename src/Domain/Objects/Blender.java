package Domain.Objects;

import Domain.Useful.Subtype;

import java.util.HashMap;

public class Blender {
    //Blender class is created for blend functionality. It is a singleton and created with Pure Fabrication pattern.
    private static Blender instance;
    private static HashMap<Subtype, HashMap<Subtype, Integer>> blendRules = new HashMap<Subtype, HashMap<Subtype, Integer>>();
    public Blender(){
        HashMap<Subtype, Integer> alphaMap = new HashMap<Subtype, Integer>();
        alphaMap.put(Subtype.BETA,2);
        alphaMap.put(Subtype.GAMMA,3);
        alphaMap.put(Subtype.SIGMA,4);
        blendRules.put(Subtype.ALPHA, alphaMap);
        HashMap<Subtype, Integer> betaMap = new HashMap<Subtype, Integer>();
        betaMap.put(Subtype.GAMMA, 2);
        betaMap.put(Subtype.SIGMA, 3);
        blendRules.put(Subtype.BETA, betaMap);
        HashMap<Subtype, Integer> gammaMap = new HashMap<Subtype, Integer>();
        gammaMap.put(Subtype.SIGMA, 2);
        blendRules.put(Subtype.GAMMA, gammaMap);
    }

    public void blend(Subtype fromType, Subtype toType, Shooter shooter){
        if(blendRules.get(fromType) != null && blendRules.get(fromType).get(toType)!= null){
            int use = blendRules.get(fromType).get(toType);
            HashMap<Subtype, Integer> shooterMap = shooter.getNumOfAtoms();
            if (shooterMap.get(fromType)>=use) {
                shooterMap.replace(fromType, shooterMap.get(fromType) - use);
                shooterMap.replace(toType, shooterMap.get(toType) + 1);
                shooter.setNumOfAtoms(shooterMap);
            }
        }
    }
    public void breakAtom(Subtype fromType, Subtype toType, Shooter shooter){
        if(blendRules.get(toType) != null && blendRules.get(toType).get(fromType)!= null){
            int add = blendRules.get(toType).get(fromType);
            HashMap<Subtype, Integer> shooterMap = shooter.getNumOfAtoms();
            if (shooterMap.get(fromType)>=1) {
                shooterMap.replace(toType, shooterMap.get(toType) + add);
                shooterMap.replace(fromType, shooterMap.get(fromType) - 1);
                shooter.setNumOfAtoms(shooterMap);
            }
        }
    }
}
