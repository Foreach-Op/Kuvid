package Domain.ObjectCreator;

import Domain.Objects.*;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;

public class PowerupFactory {
    private static PowerupFactory powerupFactory;

    private PowerupFactory(){}

    public static PowerupFactory getInstance(){
        if(powerupFactory ==null){
            powerupFactory =new PowerupFactory();
        }
        return powerupFactory;
    }


    public GameObject createPowerup(String subtype, Position position) {

        switch (subtype) {
            case FinalValues.ALPHA:
                return new Alpha_Powerup(position);

            case FinalValues.BETA:
                return new Beta_Powerup(position);

            case FinalValues.GAMMA:
                return new Gamma_Powerup(position);

            default:
                return new Sigma_Powerup(position);

        }


    }
}
