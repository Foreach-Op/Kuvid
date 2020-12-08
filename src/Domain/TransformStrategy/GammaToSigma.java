package Domain.TransformStrategy;

import Domain.Useful.FinalValues;

import java.util.HashMap;

public class GammaToSigma implements BlendBreakStrategy{
    private final int GAMMA=2;
    private final int SIGMA=1;

    @Override
    public boolean Blend(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.GAMMA);
        if(amount<GAMMA) return false;
        atomMap.put(FinalValues.GAMMA,atomMap.get(FinalValues.GAMMA)-GAMMA);
        atomMap.put(FinalValues.SIGMA,atomMap.get(FinalValues.SIGMA)+SIGMA);
        return true;
    }

    @Override
    public boolean Break(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.SIGMA);
        if(amount<SIGMA) return false;
        atomMap.put(FinalValues.SIGMA,atomMap.get(FinalValues.SIGMA)-SIGMA);
        atomMap.put(FinalValues.GAMMA,atomMap.get(FinalValues.GAMMA)+GAMMA);
        return true;
    }
}
