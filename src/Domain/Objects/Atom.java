package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;


public class Atom extends GameObject {

    public Atom(String subType,Position position,int angle) {
        super(FinalValues.ATOM, subType, position,angle,false);
        setVelocityY(-getVelocityY());
        setHeight(getL()/5);
        setWidth(getL()/5);
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));

    }
}
