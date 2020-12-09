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
        int L=GameConfiguration.getInstance().getData().getL();
        int angle = GameConfiguration.getInstance().getShooter().getAngle();
        setMovement(new MovementofObject((int) (-L / Math.tan(angle)),
                (int) L, 0));
        setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, 0));
    }

    @Override
    public String[] getCollected() {
        String[] result = new String[2];
        result[0] = this.getType();
        result[1] = this.getSubType();
        return result;
    }


}
