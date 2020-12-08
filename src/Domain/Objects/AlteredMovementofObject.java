package Domain.Objects;

import Domain.Useful.MovementType;

public class AlteredMovementofObject extends MovementofObject{
    MovementofObject alter1;
    MovementofObject alter2;
    int alterationDistance;
    boolean oneAlteration = false;
    public AlteredMovementofObject(int alterationDistance,
                                   MovementType alter1,
                                   MovementType alter2) {
        super(alter1.getMovement().getShiftX(0), alter1.getMovement().getShiftY(0), alter1.getMovement().getAngle());
        this.alter1 = alter1.getMovement();
        this.alter2 = alter2.getMovement();
    }
    public AlteredMovementofObject(int alterationDistance,
                                   MovementType alter1,
                                   MovementType alter2,
                                   boolean oneAlteration){
        super(alter1.getMovement().getShiftX(0), alter1.getMovement().getShiftY(0), alter1.getMovement().getAngle());
        this.alter1 = alter1.getMovement();
        this.alter2 = alter2.getMovement();
        this.oneAlteration = oneAlteration;

    }
    public int getShiftX(int y) {
        if(Math.floorMod(y, alterationDistance)==0) {
            return alter1.getShiftX(y);
        }
        if(Math.floorMod(y, alterationDistance)%2==0) {
            if(!oneAlteration) return alter1.getShiftX(y);
        }
        return alter2.getShiftX(y);

    }
    public int getShiftY(int y) {
        if(Math.floorMod(y, alterationDistance)==0) {
            return alter1.getShiftY(y);
        }
        if(Math.floorMod(y, alterationDistance)%2==0) {
            if(!oneAlteration) return alter1.getShiftY(y);
        }
        return alter2.getShiftY(y);
    }
}
