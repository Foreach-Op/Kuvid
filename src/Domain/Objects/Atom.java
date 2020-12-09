package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;


public class Atom extends GameObject {

    private final double heightCoef = 1;
    private final double widthCoef = 0.5;


    public Atom(String subType,Position position) {
        super(FinalValues.ATOM, subType, GameConfiguration.getInstance().getShooter().getPosition());
        int L=GameConfiguration.getInstance().getData().getL();
        int angle = GameConfiguration.getInstance().getShooter().getAngle();
        setMovement(new MovementofObject((int) (-L / Math.tan(angle)),
                (int) GameConfiguration.getInstance().getData().getL(), 0,true));
        setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));
    }


}
