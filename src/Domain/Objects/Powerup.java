package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;


import java.util.HashMap;

public class Powerup extends GameObject implements Collectable, Fireable{
    private MovementofObject movement;

    public Powerup(String subType, Position position){
        super(FinalValues.POWERUP,subType,position);
    }

    @Override
    public String[] getCollected() {
        String[] result = new String[2];
        result[0] = this.getType();
        result[1] = this.getSubType();
        return result;
    }

    @Override
    public void beFired(int angle) {
            this.movement = new MovementofObject((int) (-RunningMode.L/Math.tan(angle)), (int) RunningMode.L, 0 );

    }
}
