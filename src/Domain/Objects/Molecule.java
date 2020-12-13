package Domain.Objects;

import Domain.Utils.FinalValues;
import Domain.Utils.Position;

public class Molecule extends GameObject{

    public Molecule(String subType, Position position,int angle) {
        super(FinalValues.MOLECULE, subType, position,angle,true);
        setHeight(getL()/2);
        setWidth(getL()/2);
        //setRectangle(new Rectangle(position, widthCoef*L, heightCoef*L, angle));
    }

}
