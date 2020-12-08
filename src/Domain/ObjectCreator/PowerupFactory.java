package Domain.ObjectCreator;

import Domain.Objects.*;
import Domain.Useful.FinalValues;

public class PowerupFactory {
    private static PowerupFactory powerupFactory;

    private PowerupFactory(){}

    public static PowerupFactory getInstance(){
        if(powerupFactory ==null){
            powerupFactory =new PowerupFactory();
        }
        return powerupFactory;
    }


    public GameObject createPowerup(String subtype) {

        switch (subtype) {
            case FinalValues.ALPHA:
                return new Alpha_Powerup();

            case FinalValues.BETA:
                return new Beta_Powerup();

            case FinalValues.GAMMA:
                return new Gamma_Powerup();

            default:
                return new Sigma_Powerup();

        }


    }
}
