package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;


public class Atom extends GameObject {

    private final double heightCoef = 1;
    private final double widthCoef = 0.5;


    public Atom(String subType,Position position,int angle) {
        super(FinalValues.ATOM, subType, GameConfiguration.getInstance().getShooter().getCurrentPosition(),angle);
        int L=GameConfiguration.getInstance().getData().getL();

        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));

    }
}
