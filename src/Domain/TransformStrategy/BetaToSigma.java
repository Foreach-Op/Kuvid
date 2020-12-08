package Domain.TransformStrategy;

import Domain.Useful.FinalValues;

import java.util.HashMap;

public class BetaToSigma implements BlendBreakStrategy{
    private final int BETA=3;
    private final int SIGMA=1;

    @Override
    public boolean Blend(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.BETA);
        if(amount<BETA) return false;
        atomMap.put(FinalValues.BETA,atomMap.get(FinalValues.BETA)-BETA);
        atomMap.put(FinalValues.SIGMA,atomMap.get(FinalValues.SIGMA)+SIGMA);
        return true;
    }

    @Override
    public boolean Break(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.SIGMA);
        if(amount<SIGMA) return false;
        atomMap.put(FinalValues.SIGMA,atomMap.get(FinalValues.SIGMA)-SIGMA);
        atomMap.put(FinalValues.BETA,atomMap.get(FinalValues.BETA)+BETA);
        return true;
    }
}
