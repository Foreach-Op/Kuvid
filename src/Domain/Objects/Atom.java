package Domain.Objects;

import Domain.Modes.RunningMode;
import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;


public class Atom extends GameObject {

    public Atom(String subType,Position position,int angle) {
        super(FinalValues.ATOM, subType, position,angle,false);
        setVelocityY(-getVelocityY());
        setHeight(getL()/10);
        setWidth(getL()/10);
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));

    }
}
