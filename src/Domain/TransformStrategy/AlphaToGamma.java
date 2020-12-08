package Domain.TransformStrategy;

import Domain.Useful.FinalValues;

import java.util.HashMap;

public class AlphaToGamma implements BlendBreakStrategy{
    private final int ALPHA=3;
    private final int GAMMA=1;

    @Override
    public boolean Blend(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.ALPHA);
        if(amount<ALPHA) return false;
        atomMap.put(FinalValues.ALPHA,atomMap.get(FinalValues.ALPHA)-ALPHA);
        atomMap.put(FinalValues.GAMMA,atomMap.get(FinalValues.GAMMA)+GAMMA);
        return true;
    }

    @Override
    public boolean Break(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.GAMMA);
        if(amount<GAMMA) return false;
        atomMap.put(FinalValues.GAMMA,atomMap.get(FinalValues.GAMMA)-GAMMA);
        atomMap.put(FinalValues.ALPHA,atomMap.get(FinalValues.ALPHA)+ALPHA);
        return true;
    }
}
