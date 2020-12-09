package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;


public class Atom extends GameObject {

    private final double heightCoef = 1;
    private final double widthCoef = 0.5;


    public Atom(String subType) {
        super(FinalValues.ATOM, subType, GameConfiguration.getInstance().getShooter().getPosition());
        Position p = GameConfiguration.getInstance().getShooter().getPosition();
        int angle = GameConfiguration.getInstance().getShooter().getAngle();
        setMovement(new MovementofObject((int) (-RunningMode.L / Math.tan(angle)),
                (int) RunningMode.L, 0,true));
        setRectangle(new Rectangle(p, widthCoef, heightCoef, angle));
    }


}
