package Domain.TransformStrategy;

import Domain.Useful.FinalValues;

import java.util.HashMap;

public class AlphaToBeta implements BlendBreakStrategy{

    private final int ALPHA=2;
    private final int BETA=1;

    @Override
    public boolean Blend(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.ALPHA);
        if(amount<ALPHA) return false;
        atomMap.put(FinalValues.ALPHA,atomMap.get(FinalValues.ALPHA)-ALPHA);
        atomMap.put(FinalValues.BETA,atomMap.get(FinalValues.BETA)+BETA);
        return true;
    }

    @Override
    public boolean Break(HashMap<String, Integer> atomMap) {
        int amount=atomMap.get(FinalValues.BETA);
        if(amount<BETA) return false;
        atomMap.put(FinalValues.BETA,atomMap.get(FinalValues.BETA)-BETA);
        atomMap.put(FinalValues.ALPHA,atomMap.get(FinalValues.ALPHA)+ALPHA);
        return true;
    }
}
