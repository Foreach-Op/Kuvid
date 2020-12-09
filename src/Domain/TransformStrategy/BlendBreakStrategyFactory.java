package Domain.TransformStrategy;

import Domain.CollisionStrategy.*;
import Domain.Objects.GameObject;

public class BlendBreakStrategyFactory {

    private static BlendBreakStrategyFactory blendBreakStrategyFactory;

    private BlendBreakStrategyFactory(){}

    public static BlendBreakStrategyFactory getInstance(){
        if(blendBreakStrategyFactory==null){
            blendBreakStrategyFactory=new BlendBreakStrategyFactory();
        }
        return blendBreakStrategyFactory;
    }

    public BlendBreakStrategy getStrategy(String from, String to){
        BlendBreakStrategy blendBreakStrategy=null;
        switch (from){
            case "Alpha":
                switch (to) {
                    case "Beta": blendBreakStrategy = new AlphaToBeta();
                    case "Gamma": blendBreakStrategy = new AlphaToGamma();
                    case "Sigma": blendBreakStrategy = new AlphaToSigma();
                }
                break;
            case "Beta":
                switch (to){
                    case "Gamma": blendBreakStrategy=new BetaToGamma();
                    case "Sigma" : blendBreakStrategy=new BetaToSigma();
                }
                break;
            case "Gamma":
                blendBreakStrategy=new GammaToSigma();
                break;
        }

        return blendBreakStrategy;
    }

}
