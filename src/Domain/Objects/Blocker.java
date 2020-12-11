package Domain.Objects;

import Domain.Statistics.GameConfiguration;
import Domain.Useful.FinalValues;
import Domain.Useful.Position;
import Domain.Useful.Rectangle;

public class Blocker extends GameObject {

    public Blocker(String subType, Position position) {
        super(FinalValues.BLOCKER, subType, position,90,true);
        setWidth(getL()/2);
        setHeight(getL());
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, 0));
    }

}
