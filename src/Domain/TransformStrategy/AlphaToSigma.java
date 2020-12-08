package Domain.TransformStrategy;

import Domain.Useful.FinalValues;

import java.util.HashMap;

public class AlphaToSigma implements BlendBreakStrategy{
    private final int ALPHA=4;
    private final int SIGMA=1;

    @Override
    public boolean Blend(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.ALPHA);
        if(amount<ALPHA) return false;
        atomMap.put(FinalValues.ALPHA,atomMap.get(FinalValues.ALPHA)-ALPHA);
        atomMap.put(FinalValues.SIGMA,atomMap.get(FinalValues.SIGMA)+SIGMA);
        return true;
    }

    @Override
    public boolean Break(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.BETA);
        if(amount<SIGMA) return false;
        atomMap.put(FinalValues.SIGMA,atomMap.get(FinalValues.SIGMA)-SIGMA);
        atomMap.put(FinalValues.ALPHA,atomMap.get(FinalValues.ALPHA)+ALPHA);
        return true;
    }
}
