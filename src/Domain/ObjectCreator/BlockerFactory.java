package Domain.ObjectCreator;

import Domain.Objects.*;
import Domain.Useful.FinalValues;

public class BlockerFactory {
    private static BlockerFactory blockerFactory;

    private BlockerFactory(){}

    public static BlockerFactory getInstance(){
        if(blockerFactory ==null){
            blockerFactory =new BlockerFactory();
        }
        return blockerFactory;
    }


    public GameObject createBlocker(String subtype) {

        switch (subtype) {
            case FinalValues.ALPHA:
                return new Alpha_Blocker();

            case FinalValues.BETA:
                return new Beta_Blocker();

            case FinalValues.GAMMA:
                return new Gamma_Blocker();

            default:
                return new Sigma_Blocker();

        }


    }
}
