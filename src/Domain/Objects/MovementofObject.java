package Domain.Objects;

import Domain.Useful.MovementType;

public class MovementofObject {
    //for powerup movement can up or down;
    int shiftY; //-N to +N
    int shiftX; //-N to +N
    int angle;


    public MovementofObject(int shiftX, int shiftY){
        this.shiftX=shiftX;
        this.shiftY=shiftY;
        angle = 0;
    }
    public MovementofObject(int shiftX, int shiftY, int angle){
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public void setShiftY(int shiftY) {
        this.shiftY = shiftY;
    }

    public void setShiftX(int shiftX) {
        this.shiftX = shiftX;
    }


    public int getShiftY(int y) {
        return shiftY;
    }

    public int getShiftX(int y) {
        return shiftX;
    }





}
