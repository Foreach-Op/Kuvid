package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.Rectangle;

import java.util.HashMap;

public class Powerup extends GameObject implements Collectable {
    private MovementofObject movement;
    private int angle;
    private final double widthCoef = 1;
    private final double heightCoef = 1;

    public Powerup(String subType, Position position) {
        super(FinalValues.POWERUP, subType, position);
        setRectangle(new Rectangle(position, widthCoef, heightCoef, 0));
    }

    public Powerup(String subtype) {
        super(FinalValues.POWERUP, subtype, GameConfiguration.getInstance().getShooter().getPosition());
        Position p = GameConfiguration.getInstance().getShooter().getPosition();
        int angle = GameConfiguration.getInstance().getShooter().getAngle();
        setMovement(new MovementofObject((int) (-RunningMode.L / Math.tan(angle)),
                (int) RunningMode.L, 0));
        setRectangle(new Rectangle(p, widthCoef, heightCoef, angle));
    }

    @Override
    public String[] getCollected() {
        String[] result = new String[2];
        result[0] = this.getType();
        result[1] = this.getSubType();
        return result;
    }


}
