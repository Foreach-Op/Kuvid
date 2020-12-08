package Domain.TransformStrategy;

import Domain.Useful.FinalValues;

import java.util.HashMap;

public class BetaToGamma implements BlendBreakStrategy{
    private final int BETA=2;
    private final int GAMMA=1;

    @Override
    public boolean Blend(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.BETA);
        if(amount<BETA) return false;
        atomMap.put(FinalValues.BETA,atomMap.get(FinalValues.BETA)-BETA);
        atomMap.put(FinalValues.GAMMA,atomMap.get(FinalValues.GAMMA)+GAMMA);
        return true;
    }

    @Override
    public boolean Break(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.GAMMA);
        if(amount<GAMMA) return false;
        atomMap.put(FinalValues.GAMMA,atomMap.get(FinalValues.GAMMA)-GAMMA);
        atomMap.put(FinalValues.BETA,atomMap.get(FinalValues.BETA)+BETA);
        return true;
    }
}
