package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;


public class Atom extends GameObject {



    public Atom(String subType, Position position, int angle) {
        super(FinalValues.ATOM, subType, position,angle,false);
        setVelocityY(-getVelocityY()*getL()/50);
        setVelocityX(getVelocityX()*getL()/50);
        setHeight((int) (getL()/5));
        setWidth((int) (getL()/5));
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));

    }


}
