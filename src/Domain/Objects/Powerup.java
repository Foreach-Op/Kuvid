package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;


import java.util.HashMap;

public class Powerup extends GameObject implements Collectable{
    private MovementofObject movement;

    public Powerup(String subType, Position position){
        super(FinalValues.POWERUP,subType, position);
    }

    public Powerup(String subtype, int angle){
        super(FinalValues.POWERUP,subtype, Shooter.getInstance().position());
        this.movement = new MovementofObject((int) (-RunningMode.L/Math.tan(angle)), (int) RunningMode.L, 0 );
    }

    @Override
    public String[] getCollected() {
        String[] result = new String[2];
        result[0] = this.getType();
        result[1] = this.getSubType();
        return result;
    }


}
