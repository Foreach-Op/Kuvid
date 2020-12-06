package Domain.Objects;

import Domain.Useful.MovementType;

public class MovementofObject {
    //for powerup movement can up or down;
    int shiftY; //-N to +N
    int shiftX; //-N to +N
    MovementType movementType;
    int angle;

    public MovementofObject(int shiftX, int shiftY, MovementType movementType){
        this.shiftX=shiftX;
        this.shiftY=shiftY;
        this.movementType=movementType;
    }

    public void setShiftY(int shiftY) {
        this.shiftY = shiftY;
    }

    public void setShiftX(int shiftX) {
        this.shiftX = shiftX;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public int getShiftY() {
        return shiftY;
    }

    public int getShiftX() {
        return shiftX;
    }

    public MovementType getMovementType() {
        return movementType;
    }




}
