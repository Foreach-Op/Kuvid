package Domain.Useful;

import Domain.Objects.MovementofObject;
import Domain.Statistics.GameData;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Rectangle {
    int locationX;
    int locationY;
    double length;
    double width;
    int angle;
    ArrayList<Point> pointList;
    //This class is created for simulating the window of GameObjects.
    //will be updated, some problems occurs because of the double-int casting
    public Rectangle(Position p, double widthCoef, double heightCoef, int angle){
        this.locationX = p.getX();
        this.locationY = p.getY();
        this.length = heightCoef*GameData.L;
        this.width = widthCoef * GameData.L;
        this.angle = angle;
        initializePointList(angle);
    }
    public void initializePointList(int angle){
        pointList = new ArrayList<Point>();
        for(int x = -((int)width/2); x<width/2 ;x++){
            for(int y = -((int)length/2); y<length/2; y++){
                int rotatedX = (int) (x*Math.cos(angle) - y*Math.sin(angle)) ;
                int rotatedY = (int) (x*Math.sin(angle) + y* Math.cos(angle)) ;
                pointList.add(new Point(rotatedX + locationX, rotatedY+locationY));
            }
        }
    }
    public boolean intersects(Rectangle second){
        if (Collections.disjoint(second.pointList, this.pointList)) return false;
        return true;
    }
    public void applyMovement(MovementofObject movement){
        locationX += movement.getShiftX(locationY);
        locationY += movement.getShiftY(locationY);
        angle += movement.getAngle();
        initializePointList(angle);

    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Position getPosition(){
        return new Position(getLocationX(), getLocationY());
    }
}